package com.petclinic.simulations.utils

object Paths {

  val owners: String = "/owners"
  val owner: String = "/owners/${ownerId}"
  val vets: String = "/vets"
  val vet: String = "/vets/${vetId}"
  val pets: String = "/pets"
  val pet: String = "/pets/${petId}"
  val petType: String = "/pettypes/${petTypeId}"
  val visits: String = "/visits"
  val visit: String = "/visits/${visitId}"
}
