package com.petclinic.simulations.utils

import scala.concurrent.duration.{DurationInt, FiniteDuration}

object SimulationParameters {

  val players: Int = System.getProperty("players", "5").toInt
  val playerSuccessfulRequests: Int = System.getProperty("playerSuccessfulRequests", "99").toInt

  val rampUpDurationInSec: FiniteDuration = System.getProperty("rampUpDurationInSec", "30").toInt.seconds
  val maxDurationInMin: FiniteDuration = System.getProperty("maxDurationInMin", "2").toInt.minutes
}
