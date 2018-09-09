/**
  * Created by akapo on 2018/09/08.
  */
import akka.actor.{Actor, ActorLogging, Props}

object MyActor {
  def props = Props(MyActor())

  sealed trait Request
  case class TellMessage() extends Request
  case class AskMessageReq() extends Request
  case object GetStatus extends Request
  case object ChangeStatus extends Request

  sealed trait Response
  case class AskMessageRes() extends Response

  sealed trait Status extends Response
  case object First extends Status
  case object Second extends Status


}

case class MyActor() extends Actor with ActorLogging
{
  import MyActor._

  override def receive: Receive = first

  def first: Receive = {
    case msg: TellMessage => log.info(s"receive ${msg.getClass.getName}")
    case msg: AskMessageReq =>
      log.info(s"receive ${msg.getClass.getName}")
      sender() ! AskMessageRes()
    case GetStatus =>
      sender() ! First
    case ChangeStatus =>
      context.become(second)
      sender() ! Second
  }

  def second: Receive = {
    case GetStatus =>
      sender() ! Second
  }

}
