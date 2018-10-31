import io.gatling.http.Predef._
import io.gatling.core.Predef._

object Admin {
  val feeder = csv("token.csv").circular

  val admin = exec(http("loginGet").get("/login"))
    .pause(5)
    .feed(feeder)
  .exec(http("/login")
    .post("/login")
      .formParam("Email", "${email}")
      .formParam("Password", "${password}")
  )
    .exec { session =>
      println(session)
      session
    }
}
