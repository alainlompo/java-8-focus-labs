package org.lompo.labs.scala.vs.java

/**
 * @author LOMPO
 */
object Tuples {
  def main(args:Array[String]) {
    val javaLanguage = (1995, "Object oriented", "Polymorphic","Functional")
    val cSharpLanguage = (2001, "Object oriented", "Polymorphic", "Functional", "Operators overloading")
    
    println(cSharpLanguage._1)
    println(javaLanguage._2)
    
  }
}