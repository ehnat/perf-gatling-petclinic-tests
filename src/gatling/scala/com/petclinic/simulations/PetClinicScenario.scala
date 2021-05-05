package com.petclinic.simulations

import io.gatling.core.Predef._
import io.gatling.core.feeder._
import io.gatling.core.structure.ScenarioBuilder

import scala.concurrent.duration.{Duration, SECONDS}

object PetClinicScenario {

  val mainPath: String = "data/default"

  val petTypesFeeder: BatchableFeederBuilder[String] = csv(mainPath + "/petTypes.csv")
  val ownersFeeder: BatchableFeederBuilder[String] = csv(mainPath + "/owners.csv")
  val vetsFeeder: BatchableFeederBuilder[String] = csv(mainPath + "/vets.csv")
  val petsFeeder: BatchableFeederBuilder[String] = csv(mainPath + "/pets.csv")
  val visitsFeeder: BatchableFeederBuilder[String] = csv(mainPath + "/visits.csv")

  val defaultPause: Duration = Duration(1, SECONDS)

  val basicScenario: ScenarioBuilder =
    scenario("Basic scenario")
      .feed(ownersFeeder.circular)
      .repeat(4)(
        exec(PetClinicRequests.getOwner().pause(Duration(1, SECONDS)))
      )

      .feed(vetsFeeder.circular)
      .repeat(2)(
        exec(PetClinicRequests.getVet().pause(Duration(1, SECONDS)))
      )

      .feed(petsFeeder.circular)
      .exec(PetClinicRequests.getPet())

      .feed(petTypesFeeder.circular)
      .repeat(2)(
        exec(PetClinicRequests.getPetType().pause(Duration(1, SECONDS)))
      )

      .feed(visitsFeeder.circular)
      .repeat(3)(
        exec(PetClinicRequests.getVisit().pause(Duration(1, SECONDS)))
      )
}
