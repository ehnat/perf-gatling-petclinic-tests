package com.petclinic.simulations.json

import com.fasterxml.jackson.databind.ObjectMapper

object JacksonSupport {
  def toJsonString(test: Object): String = {
    val mapper = new ObjectMapper()

    val jsonString = mapper.writeValueAsString(test)
    System.out.println("Json string = " + jsonString)

    jsonString
  }
}
