package com.petclinic.simulations.utils

object SimulationParameters {

  val players: Int = System.getProperty("players", "5").toInt
  val playerSuccessfulRequests: Int = System.getProperty("playerSuccessfulRequests", "99").toInt

  val rampUpDuration: Int = System.getProperty("rampUpDurationInSec", "30").toInt
  val maxDuration: Int = System.getProperty("maxDurationInMin", "2").toInt
}
