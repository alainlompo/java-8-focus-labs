package org.lompo.labs.scala.vs.java

/**
 * @author LOMPO
 */
object ClosureDemo {
  def main(args:Array[String]) {
    var x = 0
    // This is a closure that captures x and increments it
    val increment = () => x +=1
    
    // This is a closure that captures x and turns it into its square
    val squares = () => x *= x
    
    // The equivalent in classic java 8 will result in compiler error
    // for x will be implicitely considered final
    increment()
    increment()
    increment()
    squares()
    println("Here is the final value of x")
    println(x)
    
  }
}