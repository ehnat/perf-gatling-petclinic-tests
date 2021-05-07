package com.petclinic.simulations

import io.gatling.core.Predef._
import io.gatling.core.feeder._
import io.gatling.core.structure.ScenarioBuilder

import scala.concurrent.duration._

object PetClinicScenario {

  val mainPath: String = "data/default"

  val ownersFeeder: BatchableFeederBuilder[String] = csv(mainPath + "/owners.csv")
  val vetsFeeder: BatchableFeederBuilder[String] = csv(mainPath + "/vets.csv")
  val visitsFeeder: BatchableFeederBuilder[String] = csv(mainPath + "/visits.csv")
  val petsFeeder: BatchableFeederBuilder[String] = csv(mainPath + "/pets.csv")
  val petTypesFeeder: BatchableFeederBuilder[String] = csv(mainPath + "/petTypes.csv")

  val pauseOneSec: FiniteDuration = Duration(1, SECONDS)

  val basicScenario: ScenarioBuilder =
    scenario("Basic scenario - check GET requests for particular values (owner, vet, visit, pet, petType)")
      .feed(ownersFeeder.circular)
      .repeat(4)(
        exec(PetClinicRequests.getOwner().pause(pauseOneSec))
      )

      .feed(vetsFeeder.circular)
      .repeat(2)(
        exec(PetClinicRequests.getVet().pause(pauseOneSec))
      )

      .feed(petsFeeder.circular)
      .exec(PetClinicRequests.getPet().pause(pauseOneSec))

      .feed(petTypesFeeder.circular)
      .repeat(2)(
        exec(PetClinicRequests.getPetType().pause(pauseOneSec))
      )

      .feed(visitsFeeder.circular)
      .repeat(3)(
        exec(PetClinicRequests.getVisit().pause(pauseOneSec))
      )
}
