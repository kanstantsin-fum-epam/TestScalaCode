import io.gatling.core.Predef._
import io.gatling.http.Predef._


object Navigations {

  val navigate = exec(http("mainPage")
    .get("/")

  )
}
