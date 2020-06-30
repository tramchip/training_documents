Scala : 


-------------Val n Var--------------
val x = 2

val x: Int = 1 + 1


var x = 2;

x = x*2;

println(x)

-------------Method--------------


def add(x: Int, y: Int): Int = {
	x + y
} 


def add(x: Int, y: Int) {
	println(x + y)
} 



 def functionExample(a:Int = 1, b:Int = 0) : Int = {   
        a+b  
 }  

-------------CLASS--------------



class Person(firstName : String, lastName: String) {

  def printFullName(): Unit =
    println(firstName + " " + lastName)

}


----------While loop---------------

var a = 10;    

while( a<=20 ){              
    println(a);  
    a = a+2                
}  

----------For loop---------------

for( a <- 1 to 10 ){  
         println(a);  
}  




var list = List(1,2,3,4,5,6,7,8,9)          

for( i <- list){                   
   	println(i)  
}  

list.foreach{ x => println(x) }  



----------IF ELSE--------
if(number%2==0){  
    println("Even number")  
}else{  
    println("Odd number")  
}  



----------Array, Seq, List---------------


val seqA = Seq(1, 2, 3)

val seqB = seqA :+ 4

val seqC = seqA ++ seqB


----------MUTABLE Array, Seq, List---------------

import scala.collection.mutable.ArrayBuffer


var name = ArrayBuffer[String]()  
    name += "one"
    name += "two"
    name += "three"


println(name) 
println(name(1)) 





