package org.lompo.labs.scala.vs.java

/**
 * The use of object actually tells scala to create the HelloBeer class as 
 * well as a single (singleton) instance of the HelloBeear class that will be used
 * The singleton design pattern is therefore implemented as a feature into scala language
 * @author LOMPO
 */
object HelloBeer {
  
  def main(args: Array[String]) {
    var n: Int = 2
    while (n <= 6) {
      println(s"Hello ${n} bottles of mango juce")
      n+=1
    }
  }
  
}