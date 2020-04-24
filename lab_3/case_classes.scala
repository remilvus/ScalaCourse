// case class CC(x: Int)
// case object O1 { val x = 2 }

// class C1(val x: Int)
// case class SubC1(y: Int) extends C1(y)


case class C1(x: Int)
case class SubC1(x: Int) extends C1(x)
