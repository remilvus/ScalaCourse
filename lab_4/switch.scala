object Appl470 {
  object WeekDay extends Enumeration {
    type WeekDay = Value
    val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
  }
  import WeekDay._
  def printDayName(day: WeekDay) = {
    day match {
      case Mon => println("Monday")
      case Tue => println("Tuesday")
      case Wed => println("Wednesday")
      case Thu => println("Thursday")
      case Fri => println("Friday")
      case Sat => println("Saturday")
      case Sun => println("Sunday")
   //   case _   => println("What the he..?!")
    }
  }
  def main(args: Array[String]) {
    for (day <- WeekDay.values) println(day)
  }
}

sealed abstract class Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) 
extends Expr

object ExprEval {
  def simplify(e: Expr): Expr = e match {
    case UnOp("+", Number(num)) => Number(num)
    case BinOp("+", left, right) =>
      Number(evaluate(left) + evaluate(right))
    case _ => e
  }
  def evaluate(e: Expr): Double = ExprEval.simplify(e) match {
    case Number(num) => num
    case BinOp("+", left, right) =>
      evaluate(left) + evaluate(right)
    //...
    case _ =>
      println("Unmatched expression!"); 0
  }
}
object Appl471 {
  def main(args: Array[String]) {
    import ExprEval._

    println(simplify(UnOp("+", Number(10))))
    println(simplify(BinOp("+", 
                     BinOp("+", Number(1.5), Number(5.5)),
                     Number(3))))
  }
}
