package rysh

import org.scalajs.dom
import rysh.shared.SharedMessages
import com.raquo.laminar.api.L._

object ScalaJSExample {

  def main(args: Array[String]): Unit = {
    dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
  }
}
