## Performance tests (Petclinic, Gatling)

#### Run tests
a) Run all com.petclinic.simulations:
``./gradlew clean gatlingRun``
``gradlew.bat clean gatlingRun``

b) Run one simulation implemented in com.petclinic.simulations.BasicSimulation class:
  
-- with default values:

`./gradlew clean gatlingRun-com.petclinic.simulations.BasicSimulation`
`gradlew.bat clean gatlingRun-com.petclinic.simulations.BasicSimulation`

-- with set values from command line:
- `./gradlew clean gatlingRun-com.petclinic.simulations.BasicSimulation -Dplayers=6 -DplayerSuccessfulRequests=99`
- `gradlew.bat clean gatlingRun-com.petclinic.simulations.BasicSimulation -Dplayers=6 -DplayerSuccessfulRequests=99`
  
- `gradlew.bat clean gatlingRun-com.petclinic.simulations.ComplexSimulation -Dplayers=10 -DplayerSuccessfulRequests=99 -DrampUpDurationInSec=20 -DmaxDurationInMin=2`

#### Gatling helpful docs:
- general: `https://gatling.io/docs/current/`
- concepts: `https://gatling.io/docs/current/general/concepts/`
- simulation: `https://gatling.io/docs/current/general/simulation_setup/`
- scenario: `https://gatling.io/docs/current/general/scenario/`
- requests: `https://gatling.io/docs/current/http/`

#### Integration Gatling with Gradle (Gradle plugin):
- `https://gatling.io/docs/current/extensions/gradle_plugin/`
- gatling plugin is not supported by gradle 7 (max. supported version 6.6.1) - fix is in progress: `https://github.com/gatling/gatling-gradle-plugin/pull/32`

#### Performance tests articles:
- `https://automationrhapsody.com/performance-testing-with-gatling/`
- `https://automationrhapsody.com/how-to-do-proper-performance-testing/`
- `https://automationrhapsody.com/performance-load-stress-and-soak-testing/` - backend perf tests
- `https://automationrhapsody.com/performance-testing-in-the-browser/` - frontend perf tests

#### Gatling code examples:
- `https://github.com/gatling/gatling-gradle-plugin-demo`
- `https://github.com/llatinov/sample-performance-with-gatling`

#### Basic scala:
- `https://automationrhapsody.com/performance-testing-with-gatling-scala-fundamentals/`
- `https://www.tutorialspoint.com/scala/index.htm`
- `https://blog.jooq.org/2014/08/01/the-10-most-annoying-things-coming-back-to-java-after-some-days-of-scala/`
