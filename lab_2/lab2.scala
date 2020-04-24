class Person(val givenName: String, var surname: String, protected val id: String){
    def name : String = { givenName + " " + surname }
}

// object Appl {
//   def main(args: Array[String]) {
//     val p = new Person("Jan", "Kowalski", "1234567890")
//     p.surname = "Brando"
//     println(p.name)
//   }
// }

object Appl extends App {
  val p = new Person("Jan", "Kowalski", "1234567890")
  println(p.name)
}
