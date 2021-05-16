package com.petclinic.simulations

import com.petclinic.simulations.utils.{HttpConfig, SimulationParameters}
import io.gatling.core.Predef._

class BasicSimulation extends Simulation {

  val players: Int = SimulationParameters.players
  val playerSuccessfulRequests: Int = SimulationParameters.playerSuccessfulRequests
  val maxResponseTimeInMilisec: Int = 1500
  val requestsPerSec: Int = 5
  val marginRequestsPerSec: Int = 2

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
    .protocols(HttpConfig.httpConf)
    .assertions(
      global.successfulRequests.percent.gte(playerSuccessfulRequests),
      global.requestsPerSec.around(requestsPerSec, marginRequestsPerSec),
      forAll.responseTime.max.lt(maxResponseTimeInMilisec)
    )

  after {
    println("Basic simulation is finished")
  }
}
