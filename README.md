### I. PROJECT DESCRIPTION:

The project contains performance tests (two simulations) for Petclinic application.

Simulations:

A. BasicSimulation:

- run sequence of GETS requests (GET owner, GET vet, GET pet, GET petType, GET visit)
- every request is running a couple of times
- data for tests are taken form files in `gatlin/resources/data/default`

B. ComplexSimulation
- run sequence of calls: addOwnerWithFirstName, addPetWithName, addVisitWithDescription
- sequence is running for some time (`maxDurationInMin`)
- data (names, descriptions) are generated randomly by faker


### Technical description
- Used technologies: Scala, Gradle
- Load testing tool: Gatling

### II. APPLICATION UNDER TEST:
### How to run application under test
Running the application under test is the entry point for tests.

Repository for Petclinic application:
`https://github.com/spring-petclinic/spring-petclinic-rest`.

There is detailed information how to configure and run application.

Below I put a shortcut how to run Petclinic:

- `git clone https://github.com/spring-petclinic/spring-petclinic-rest.git`
- `cd spring-petclinic-rest`
- `./mvnw spring-boot:run`

### Documentation
When application is run api documentation can be found here:
`http://localhost:9966/petclinic/swagger-ui.html`


### III. PROJECT DETAILS:
### Test reports
- `build/reports/gatling/{simulation_folder}/index.html`


### How to run tests
a) run all com.petclinic.simulations:
- mac: `./gradlew clean gatlingRun`
- windows: `gradlew.bat clean gatlingRun`

b) run one simulation implemented in com.petclinic.simulations.BasicSimulation class:

-- with default values:

- mac: `./gradlew clean gatlingRun-com.petclinic.simulations.BasicSimulation`
- windows: `gradlew.bat clean gatlingRun-com.petclinic.simulations.BasicSimulation`

-- with set values from command line:
- mac: `./gradlew clean gatlingRun-com.petclinic.simulations.BasicSimulation -Dplayers=6 -DplayerSuccessfulRequests=99`
- windows: `gradlew.bat clean gatlingRun-com.petclinic.simulations.BasicSimulation -Dplayers=6 -DplayerSuccessfulRequests=99`

c) run one simulation implemented in com.petclinic.simulations.ComplexSimulation class:
- mac: - windows: `./gradlew clean gatlingRun-com.petclinic.simulations.ComplexSimulation -Dplayers=10 -DplayerSuccessfulRequests=99 -DrampUpDurationInSec=20 -DmaxDurationInMin=2`
- windows: `gradlew.bat clean gatlingRun-com.petclinic.simulations.ComplexSimulation -Dplayers=10 -DplayerSuccessfulRequests=99 -DrampUpDurationInSec=20 -DmaxDurationInMin=2`


### USEFUL LINKS:
### Gatling helpful docs
- general: `https://gatling.io/docs/current/`
- concepts: `https://gatling.io/docs/current/general/concepts/`
- simulation: `https://gatling.io/docs/current/general/simulation_setup/`
- scenario: `https://gatling.io/docs/current/general/scenario/`
- requests: `https://gatling.io/docs/current/http/`

### Integration Gatling with Gradle (Gradle plugin)
- `https://gatling.io/docs/current/extensions/gradle_plugin/`
- gatling plugin is not supported by gradle 7 (max. supported version 6.6.1) - fix is in progress: `https://github.com/gatling/gatling-gradle-plugin/pull/32`

### Performance tests articles
- `https://automationrhapsody.com/performance-testing-with-gatling/`
- `https://automationrhapsody.com/how-to-do-proper-performance-testing/`
- `https://automationrhapsody.com/performance-load-stress-and-soak-testing/` - backend perf tests
- `https://automationrhapsody.com/performance-testing-in-the-browser/` - frontend perf tests

### Gatling code examples
- `https://github.com/gatling/gatling-gradle-plugin-demo`
- `https://github.com/llatinov/sample-performance-with-gatling`

### Basic scala
- `https://automationrhapsody.com/performance-testing-with-gatling-scala-fundamentals/`
- `https://www.tutorialspoint.com/scala/index.htm`
- `https://blog.jooq.org/2014/08/01/the-10-most-annoying-things-coming-back-to-java-after-some-days-of-scala/`
