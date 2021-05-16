package com.petclinic.simulations.utils

import io.gatling.core.Predef._
import io.gatling.http.Predef.http
import io.gatling.http.protocol.HttpProtocolBuilder
import io.restassured.http.ContentType

object HttpConfig extends Simulation {

  val jsonContentType: String = ContentType.JSON.toString()

  val httpConf: HttpProtocolBuilder =
    http
      .baseUrl("http://localhost:9966/petclinic/api")
      .contentTypeHeader(jsonContentType)
      .acceptHeader(jsonContentType)
      .inferHtmlResources() //automatically parse HTML to find embedded resources and load them asynchronously
}
