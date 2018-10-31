import io.gatling.core.Predef._
import io.gatling.http.Predef._


class BasicSimulation extends Simulation {

  val httpConf = http
      .proxy(Proxy("127.0.0.1", 8888).httpsPort(8888))
    .baseURL("http://192.168.56.101")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

//  val adm = scenario("LogIN").exec(Admin.admin)
  val scn = scenario("BasicSimulation").exec(Navigations.navigate, Admin.admin)
  setUp(
    scn.inject(atOnceUsers(1))
//    adm.inject(atOnceUsers(10))
  ).protocols(httpConf)


  before {
    println("Simulation is about to start!")
  }

  after {
    println("Simulation is finished!")
  }
}
