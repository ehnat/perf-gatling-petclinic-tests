package com.petclinic.simulations.config

import com.typesafe.config.{Config, ConfigException, ConfigFactory}

import java.io.File

object TestConfig {

  val env: String = System.getProperty("env", "default")
  val envConfig: Config = loadConfigFile(s"src/gatling/resources/env/$env.conf")

  def getValueFromEnvConfig(key: String): String = {
    var value = ""
    try {
      value = envConfig.getString(key)
      println(s"Parameter under test: $key = $value")
    } catch {
      case e: ConfigException.Missing =>
        print(s"${key} is not found")
        System.exit(1)
    }
    value
  }

  private def loadConfigFile(path: String): Config = {
    val config = ConfigFactory.parseFile(new File(path))
    if (config.isEmpty) {
      throw new ConfigException.BadPath(path, "wrong config file")
    }
    config
  }
}
