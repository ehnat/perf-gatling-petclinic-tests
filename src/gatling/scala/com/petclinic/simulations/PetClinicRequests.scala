package com.petclinic.simulations

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
}
