class Int2DVec private(val x: Int, val y: Int) {

  def +(other: Int2DVec) = new Int2DVec(x + other.x, y + other.y)
  def unary_- = new Int2DVec(-x, -y)
  def -(other: Int2DVec) = new Int2DVec(x - other.x, y - other.y)
  def *(other: Int2DVec) = x * other.x + y * other.y
  override def toString() = "(" + x.toString + "," + y.toString + ")"
  
//   def this() = { 
//     this(0, 0)
//     println("Creating Int2DVec(0,0)") 
//   }

//   def this(prototype: Int2DVec) = { 
//     this(prototype.x, prototype.y)
//     println("Copy-constructor working") 
//   }
}

object Int2DVec {
  def apply(x: Int, y: Int) = new Int2DVec(x, y)
  def apply() = new Int2DVec(0, 0)
  def apply(prototype: Int2DVec) = new Int2DVec(prototype.x, prototype.y)
}


object Appl {
  def main(agrs: Array[String]) {
    val v0 = Int2DVec
    println(v0)
    println(v0())
    val v1 = Int2DVec(1, 2) // Int2DVec.apply(1, 2)
    val v2 = Int2DVec(10, 20)
    println(v1 + v2)
    println(v1 - v2)
    println(v1 * v2)
    println(v1.*(v2))
    println(-v2)
    println(v2.unary_-)
    // println(new Int2DVec(-v2))
    // println(new Int2DVec())
    println(Int2DVec(-v2))
    println(Int2DVec())
  }
}
