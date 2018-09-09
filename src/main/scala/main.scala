
import akka.actor.ActorSystem
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.Await
import scala.concurrent.duration._
/**
  * Created by akapo on 2018/09/08.
  */
object main extends App {
  import MyActor._
  val system = ActorSystem("myActor")

  val myActor = system.actorOf(MyActor.props)
  myActor ! TellMessage()

  Await.result(system.whenTerminated, Duration.Inf)
}
