package com.petclinic.simulations.utils

object SimulationParameters {

  val players: Int = System.getProperty("players", "5").toInt
  val playerSuccessfulRequests: Int = System.getProperty("playerSuccessfulRequests", "99").toInt
}
