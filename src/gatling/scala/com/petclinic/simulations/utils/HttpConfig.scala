package com.petclinic.simulations.utils

import io.gatling.core.Predef._
import io.gatling.http.Predef.http
import io.gatling.http.protocol.HttpProtocolBuilder
import io.restassured.http.ContentType

object HttpConfig extends Simulation {

  val httpConf: HttpProtocolBuilder =
    http
      .baseUrl("http://localhost:9966/petclinic/api")
      .contentTypeHeader(ContentType.JSON.toString())
      .acceptHeader(ContentType.JSON.toString())
      .inferHtmlResources() //automatically parse HTML to find embedded resources and load them asynchronously
}
