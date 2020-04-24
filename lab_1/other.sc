for (i <- 1 until 5; j <- i+1 to 5) println(i, j)


val xsa = for (i <- (1 to 3).toArray) yield(i)
var i = 1
while(i<4){
    xsa(i-1) = i
    i += 1
}
println(xsa(0), xsa(1), xsa(2))

def printName(name: String = "Joe", surname: String = "Doe"){
    println(name + " " + surname)
}