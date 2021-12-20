package rysh

import akka.http.scaladsl.server.Directives

class WebService() extends Directives {

  val route = {
    get {
        pathSingleSlash {
          getFromResource("index.html")
        } ~
        path("ping") {
          complete("PONG!")
        } ~
        path("crash") {
          sys.error("BOOM!")
        }
    } ~
      pathPrefix("assets" / Remaining) { file =>
        // optionally compresses the response with Gzip or Deflate
        // if the client accepts compressed responses
        encodeResponse {
          getFromResource("public/" + file)
        }
      }
  }
}
