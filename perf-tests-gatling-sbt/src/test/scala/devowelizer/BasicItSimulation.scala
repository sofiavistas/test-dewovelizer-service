package devowelizer

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class BasicItSimulation extends Simulation {

  val scn = scenario("10 users at once for 10 times").repeat(10) {
    exec(http("GET /:input")
      .get("http://127.0.0.1:8080/casumo")
      .check(status.is(200))
      )
  }

  setUp(scn.inject(atOnceUsers(10)))
  .assertions(global.successfulRequests.percent.is(100))
}
