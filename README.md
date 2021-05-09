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
- `gradlew.bat clean gatlingRun-com.petclinic.simulations.ComplexSimulation -Dplayers=2 -DplayerSuccessfulRequests=99`

#### Gatling helpful docs:
- concepts: `https://gatling.io/docs/current/general/concepts/`
- simulation: `https://gatling.io/docs/current/general/simulation_setup/`
- scenario: `https://gatling.io/docs/current/general/scenario/`
- requests: `https://gatling.io/docs/current/http/`
