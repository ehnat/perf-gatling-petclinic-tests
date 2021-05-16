package com.petclinic.simulations

import com.petclinic.simulations.utils.{HttpConfig, SimulationParameters}
import io.gatling.core.Predef._
import scala.concurrent.duration.{Duration, FiniteDuration, MINUTES, SECONDS}

class ComplexSimulation extends Simulation {

  val players: Int = SimulationParameters.players
  val playerSuccessfulRequests: Int = SimulationParameters.playerSuccessfulRequests

  val rampUpDurationInSec: FiniteDuration = Duration(SimulationParameters.rampUpDuration, SECONDS)
  val duration5Sec: FiniteDuration = Duration(5, SECONDS)
  val maxDurationInMin: FiniteDuration = Duration(SimulationParameters.maxDuration, MINUTES)

  val maxResponseTimeInMilisec: Int = 3000
  val requestsPerSec: Int = 35
  val marginRequestsPerSec: Int = 5

  before {
    println(
      s"""
         |Complex simulation for $players players
         |is started
         |with number of successful requests >= $playerSuccessfulRequests
         |and response time < $maxResponseTimeInMilisec (milisec)
         |""".stripMargin
    )
  }

  setUp(
    PetClinicScenario.addOwnerPetVisitScenario
      .inject(
        nothingFor(duration5Sec),
        atOnceUsers(3 * players),
        nothingFor(duration5Sec),
        rampUsers(players) during (rampUpDurationInSec),
      )
  )
    .protocols(HttpConfig.httpConf)
    .maxDuration(maxDurationInMin)
    .assertions(
      global.successfulRequests.percent.gte(playerSuccessfulRequests),
      global.requestsPerSec.around(requestsPerSec, marginRequestsPerSec),
      forAll.responseTime.max.lt(maxResponseTimeInMilisec)
    )

  after {
    println("Complex simulation is finished")
  }
}
