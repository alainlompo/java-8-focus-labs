package org.lompo.labs.scala.vs.java

/**
 * Using an immutable lambda expression we go functional style in this example
 * Scala talks about anonymous functions and closures (equivalent) to describe
 * lambda expressions
 * @author LOMPO
 */
object HelloCastle {
  def main(args:Array[String]) {
    // Everything is an object in Scala
    // the <to> method of an Int object takes another Int as a parameter to produce a Range
    // Therefore the 2.to(6) will produce the Int range from 2 to 6
    // A range has a foreach method that is exactly the same as the Java forEach
    // Scala also offers the infix notation on one parameter methods
    // So 2.to(6) becomes 2 to 6 and (2.to(6)).foreach becomes 2 to 6 foreach
    // Scala lambda expressions arrow is => instead of the java 8 ->
    2 to 6 foreach {n => println(s"Hello ${n} victorian castles")}
  }
}