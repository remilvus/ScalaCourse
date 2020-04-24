trait Fraction {
  val num: Int
  val denom: Int
  def *(other: Fraction): Fraction
  def +(other: Fraction): Fraction
  def -(other: Fraction): Fraction
  def /(other: Fraction): Fraction
}

trait Loggable {
  def log(timeStamp: Long, msg: String) =
    println("[" + timeStamp.toString + "]: " + msg)
}

trait Simplifiable {
    def simplify(): Fraction
}

object Fraction {
  // one of the "creational patterns/idioms"
  def apply(num: Int, denom: Int, loggable: Boolean = false): Fraction =
    if (loggable) new LoggableImpl(num, denom)
    else new SimplImpl(num, denom)

  private class DefaultImpl(val num: Int, val denom: Int) extends Fraction {
    override def *(other: Fraction): Fraction =
      Fraction(this.num * other.num, this.denom * other.denom)
    override def +(other: Fraction): Fraction =
      Fraction(this.num * other.denom + other.num * this.denom, this.denom * other.denom)
    override def -(other: Fraction): Fraction =
      Fraction(this.num * other.denom - other.num * this.denom, this.denom * other.denom)
    override def /(other: Fraction): Fraction =
      Fraction(this.num * other.denom, other.num * this.denom)
    override def toString() = num.toString + "/" + denom.toString
  }

  private class LoggableImpl(num: Int, denom: Int)
  extends DefaultImpl(num, denom) with Loggable {
    def timeStamp = System.nanoTime // to keep the example short...
    override def *(other: Fraction): Fraction = {
      log(timeStamp, "multiplying " + this.toString + " by " + other.toString)
      // super.*(other) is not loggable
      Fraction(this.num * other.num, this.denom * other.denom, true)
    }
  }

  private class SimplImpl(num: Int, denom: Int)
  extends DefaultImpl(num, denom) with Simplifiable {
    def simplify() = {
        var num = this.num
        var denom = this.denom
        val primes = List(2,3,5,7,11,13,17,19,23)
        for (value <- primes){
            while(num % value == 0 && denom % value == 0){
                num /= value
                denom /= value
            }
        }
        Fraction(num, denom)
    }
    override def toString() = {
        val simple = this.simplify
        simple.num.toString + "/" + simple.denom.toString
        }
    }
}

object Appl {
  def main(agrs: Array[String]) {
    val f1 = Fraction(3, 7)
    val f2 = Fraction(4, 9)
    val f3 = Fraction(1, 19, true)
    val f4 = Fraction(1, 14)
    val f1f2 = f1 * f2
    println(f1.toString + " * " + f2.toString + " = " + f1f2)
    println(f3.toString + " * " + f2.toString + " * " +
            f1.toString + " = " + f3 * f2 * f1)
    println(f1.toString + " + " + f4.toString + " = " + (f4 + f1))
    println(f1.toString + " - " + f4.toString + " = " + (f1 - f4))
    println(f1.toString + " / " + f4.toString + " = " + (f1 / f4))
  }
}