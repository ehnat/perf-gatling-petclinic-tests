package com.petclinic.simulations

import com.petclinic.simulations.utils.SimulationParameters
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import io.restassured.http.ContentType

class BasicSimulation extends Simulation {

  val players: Int = SimulationParameters.players
  val playerSuccessfulRequests: Int = SimulationParameters.playerSuccessfulRequests
  val maxResponseTimeInMilisec: Int = 1500
  val requestsPerSec: Int = 5
  val marginRequestsPerSec: Int = 2

  val httpConf: HttpProtocolBuilder =
    http
      .baseUrl("http://localhost:9966/petclinic/api")
      .contentTypeHeader(ContentType.JSON.toString())
      .acceptHeader(ContentType.JSON.toString())
      .inferHtmlResources() //automatically parse HTML to find embedded resources and load them asynchronously

  before {
    println(
      s"""
         |Basic simulation for $players players
         |is started
         |with number of successful requests >= $playerSuccessfulRequests
         |and response time < $maxResponseTimeInMilisec (milisec)
         |""".stripMargin
    )
  }

  setUp(
    PetClinicScenario.basicScenario
      .inject(
        atOnceUsers(players)
      )
  )
    .protocols(httpConf)
    .assertions(
      global.successfulRequests.percent.gte(playerSuccessfulRequests),
      global.requestsPerSec.around(requestsPerSec, marginRequestsPerSec),
      forAll.responseTime.max.lt(maxResponseTimeInMilisec)
    )

  after {
    println("Basic simulation is finished")
  }
}
