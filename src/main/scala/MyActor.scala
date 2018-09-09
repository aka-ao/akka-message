/**
  * Created by akapo on 2018/09/08.
  */
import akka.actor.{Actor, ActorLogging, Props}

object MyActor {
  def props = Props(MyActor())

  case class TellMessage()
}

case class MyActor() extends Actor with ActorLogging
{
  import MyActor._

  override def receive: Receive = {
    case msg: TellMessage => log.info(s"receive ${msg.getClass.getName}")
  }

}
