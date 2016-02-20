package org.lompo.labs.scala.vs.java

/**
 * The Scala val keyword refers to a non reassignable to variable (Java's final equivalent)
 * var is a read-write variable
 * @author LOMPO
 */
object ScalaCollections {
  def main (args:Array[String]) {
    val studentWithNote = Map("John"-> 18, "Creg"->  16, "Michael" ->13)
    val topics = List("Maths", "Physics", "Biology", "Chemistry")
    val fractals = Set("Mandelbrot","Julia", "Snow flakes")
    
    // Scala collections are all immutables
    // Example here
    val firstNames = Set("Mary","Collince", "Mark")
    firstNames + "John"
    println ("Could we change the set?")
    println(firstNames)
    val newFirstNames = firstNames + "Luc"
    println(newFirstNames)
    println(firstNames)
    
  }
}