package org.lompo.labs.scala.vs.java

/**
 * @author LOMPO
 */
object CompositionWithTrait {
  def main(args:Array[String]) {
    // Though PlasticRuler does not extends explicitely the Expandable trait
    // We can do in at instantiation phase in compile time using the [with] keyword
    val ruler1 = new PlasticRuler() with Expandable
    println(ruler1.isContracted())
    println(ruler1.isContracted())
    
    // It does not mean that the whole class inherits the behaviour
    // But only the targeted instance
    val ruler2 = new PlasticRuler()
    
    // Uncomment the line below to witness the compile time error
    // println(ruler2.isContracted())
  }
}