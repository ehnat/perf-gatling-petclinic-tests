package com.petclinic.simulations

import com.github.javafaker.Faker
import io.gatling.core.Predef._
import io.gatling.core.feeder._
import io.gatling.core.structure.ScenarioBuilder

import scala.concurrent.duration._

object PetClinicScenario {

  val faker = new Faker()

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

  val addOwnerPetVisitScenario: ScenarioBuilder = {
    val ownerFirstName: String = s"o_${faker.name().firstName()}"
    val petName: String = s"p_${faker.name().name()}"
    val visitDescription: String = s"v_${faker.animal().name()}"

    scenario("Add owner, pet, visit")
      .forever(
        feed(petTypesFeeder.random)
          exec (PetClinicRequests.addOwnerWithFirstName(ownerFirstName).pause(pauseOneSec))
          exec (PetClinicRequests.addPetWithName(petName).pause(pauseOneSec))
          exec (PetClinicRequests.addVisitWithDescription(visitDescription).pause(pauseOneSec))
      )
  }
}
