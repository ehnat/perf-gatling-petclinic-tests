package com.petclinic.simulations

import com.petclinic.databuilders.factories.{OwnerFactory, PetFactory, VisitFactory}
import com.petclinic.simulations.json.JacksonSupport
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import com.petclinic.simulations.utils.Paths

object PetClinicRequests {

  def getOwner(): ChainBuilder = {
    exec(
      http("GET owner (${ownerId}, ${ownerFirstName})")
        .get(Paths.owner)
        .check(status.is(200))
        .check(bodyString.exists)
        .check(jsonPath("$.firstName").is("${ownerFirstName}"))
    )
  }

  def addOwnerWithFirstName(firstName: String): ChainBuilder = {
    exec(
      http(s"Add owner $firstName")
        .post(Paths.owners)
        .body(StringBody(JacksonSupport.toJsonString(OwnerFactory.getOwner(firstName)))).asJson
        .check(status.is(201))
        .check(bodyString.exists)
        .check(jsonPath("$.id").exists)
        .check(jsonPath("$.firstName").is(firstName))
    )
  }

  def getVet(): ChainBuilder = {
    exec(
      http("GET vet (${vetId}, ${vetFirstName})")
        .get(Paths.vet)
        .check(status.is(200))
        .check(bodyString.exists)
        .check(jsonPath("$.firstName").is("${vetFirstName}"))
    )
  }

  def getPet(): ChainBuilder = {
    exec(
      http("GET pet (${petId}, ${petName})")
        .get(Paths.pet)
        .check(status.is(200))
        .check(bodyString.exists)
        .check(jsonPath("$.name").is("${petName}"))
    )
  }

  def addPetWithName(petName: String): ChainBuilder = {
    exec(
      http(s"Add pet $petName")
        .post(Paths.pets)
        .body(StringBody(JacksonSupport.toJsonString(PetFactory.petRequest(petName)))).asJson
        .check(status.is(201))
        .check(bodyString.exists)
        .check(jsonPath("$.id").exists)
        .check(jsonPath("$.name").is(petName))
    )
  }

  def getPetType(): ChainBuilder = {
    exec(
      http("GET petType (${petTypeId}, ${petTypeName})")
        .get(Paths.petType)
        .check(status.is(200))
        .check(bodyString.exists)
        .check(jsonPath("$.name").is("${petTypeName}"))
        .check(jsonPath("$.id").is("${petTypeId}"))
    )
  }

  def getVisit(): ChainBuilder = {
    exec(
      http("GET visit (id:${visitId})")
        .get(Paths.visit)
        .check(status.is(200))
        .check(bodyString.exists)
        .check(jsonPath("$.id").is("${visitId}"))
    )
  }

  def addVisitWithDescription(description: String): ChainBuilder = {
    exec(
      http(s"Add visit $description")
        .post(Paths.visits)
        .body(StringBody(JacksonSupport.toJsonString(VisitFactory.visitRequest(description)))).asJson
        .check(status.is(201))
        .check(bodyString.exists)
        .check(jsonPath("$.id").exists)
        .check(jsonPath("$.description").is(description))
    )
  }
}
