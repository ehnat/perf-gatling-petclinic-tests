package com.petclinic.simulations

import com.petclinic.simulations.utils.SimulationParameters
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import io.restassured.http.ContentType

class BasicSimulation extends Simulation {

  val players: Int = SimulationParameters.players
  val playerSuccessfulRequests: Int = SimulationParameters.playerSuccessfulRequests

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
         |testing text
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
      global.successfulRequests.percent.gte(playerSuccessfulRequests)
    )

  after {
    println("Basic simulation is finished")
  }
}
