object Appl41 {
  def factorial(n: Int) : Int = {
    assert(n >= 0)
    if (n == 0 || n == 1) 1
    else n * factorial(n - 1)
  }

  def fibb(n: Int) : Int = {
    assert(n >= 0)
    if (n == 0 || n == 1) n
    else fibb(n - 2) + fibb(n - 1)
  }

  def main(args: Array[String]) {
    println("5! = " + factorial(5))
    println("Fibb(10) = " + fibb(10))
  }
}

object Appl42 {
  def checkPredicate(pred: Boolean,
                     predAsString: String,
                     prefix: String = "Checking if ") {
    if (pred) println(prefix + predAsString + ": OK")
    else println(prefix + predAsString + ": Fail")
  }
  def sumArrayIter(elems: Array[Int]) = {
    var sum = 0
    for (i <- elems) sum += i
    sum
  }
  def sumArrayRec1(i: Int, elems: Array[Int]): Int = {
  if (i < elems.size) elems(i) + sumArrayRec1(i + 1, elems)
  else 0
  }

    def sumArrayRec2(elems: Array[Int]) = {
    val size = elems.size
    def goFrom(i: Int): Int = {
        if (i < size) elems(i) + goFrom(i+1)
        else 0
    }
    goFrom(0)
    }


  def main(args: Array[String]) {
    val a1To5 = (1 to 5).toArray
    println("Testing with a1To5 = " +
            a1To5.mkString("Array(", ", ", ") ..."))
    val expectResult = 15
    checkPredicate(sumArrayIter(a1To5) == expectResult,
                   "sumArrayIter(0, a1To5) == " + expectResult)
    checkPredicate(sumArrayRec1(0, a1To5) == expectResult,
                   "sumArrayRec1(0, a1To5) == " + expectResult)
    checkPredicate(sumArrayRec2(a1To5) == expectResult,
                   "sumArrayRec2(a1To5) == " + expectResult)
  }
}

object Appl43 {
  def checkPredicate(pred: Boolean,
                     predAsString: String,
                     prefix: String = "Checking if ") {
    if (pred) println(prefix + predAsString + ": OK")
    else println(prefix + predAsString + ": Fail")
  }
  def maxIter(elems: Array[Int]) = {
    var max = 0
    for (i <- elems) if (i > max) max = i
    max
  }
  def maxRec1(i: Int, maxEl: Int, elems: Array[Int]): Int = {
    if (i < elems.size) maxRec1(i+1, math.max(maxEl, elems(i)), elems)
    else maxEl
  }
  def maxRec2(elems: Array[Int]) = {
    def goFrom(i: Int, maxEl: Int, size: Int): Int = {
      if (i < size) goFrom(i+1, math.max(maxEl, elems(i)), size)
      else maxEl
    }
    goFrom(0, 0, elems.size)
  }
  def main(args: Array[String]) {
    val arr1 = Array(3, 12, 43, 4, 10)
    println("Testing with arr1 = " +
            arr1.mkString("Array(", ", ", ") ..."))
    val expectResult = 43
    checkPredicate(maxIter(arr1) == expectResult,
                   "maxIter(arr1) == " + expectResult)
    checkPredicate(maxRec1(0, 0, arr1) == expectResult,
                   "maxRec1(0, 0, arr1) == " + expectResult)
    checkPredicate(maxRec2(arr1) == expectResult,
                   "maxRec2(arr1) == " + expectResult)
  }
}

object Appl44 {
  def sumArrayRec2(elems: Array[Int]) = {
    def goFrom(i: Int, size: Int, elms: Array[Int]): Int = {
      if (i < size) elms(i) + goFrom(i + 1, size, elms)
      else 0
    }
    goFrom(0, elems.size, elems)
  }

  def recurseTest(i: Int, j: Int, arr: Array[Int]): Int = {
  try {
    recurseTest(i + 1, j + 1, arr)
  } catch { case e: java.lang.StackOverflowError =>
    println("Recursion depth on this system is " + i + ".")
    i
  }
}

  def main(args: Array[String]) {
    // println("sumArrayRec2 = " +
    //         sumArrayRec2((0 until 50000).toArray))
  val recDepth = recurseTest(0, 0, Array(1))
  println("sumArrayRec2 = " + 
          sumArrayRec2((0 until recDepth).toArray))
  }
}

object Appl45 {
  import scala.annotation.tailrec
  
  def sumArrayRec2(elems: Array[Int]) = {
    //@tailrec
    def goFrom(i: Int, size: Int, elms: Array[Int]): Int = {
      if (i < size) elms(i) + goFrom(i + 1, size, elms)
      else 0
    }
    goFrom(0, elems.size, elems)
  }

  def sumArrayRec3(elems: Array[Int]) = {
    @tailrec
    def goFrom(i: Int,
               size: Int,
               elms: Array[Int],
               acc: Int): Int = {
      if (i < size) goFrom(i + 1, size, elms, acc + elms(i))
      else acc
    }
    goFrom(0, elems.size, elems, 0)
  }

  def main(args: Array[String]) {
    println("sumArrayRec3 = " +
            sumArrayRec3((0 until 30000).toArray))
  }
}
