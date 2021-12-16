package rysh

import org.scalajs.dom
import rysh.shared.SharedMessages
import com.raquo.laminar.api.L._

object ScalaJSExample {

  def main(args: Array[String]): Unit = {


    val nameVar = Var(initial = "world")

    val rootElement = div(
      label("Your name: "),
      input(
        onMountFocus,
        placeholder := "Enter your name here",
        inContext { thisNode => onInput.map(_ => thisNode.ref.value) --> nameVar }
      ),
      span(
        "Hello, ",
        child.text <-- nameVar.signal.map(_.toUpperCase)
      )
    )

    // In most other examples, containerNode will be set to this behind the scenes
    val containerNode = dom.document.querySelector("#laminar")


    render(containerNode, rootElement)
    
    dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
  }
}
