package org.lompo.labs.scala.vs.java

/**
 * @author LOMPO
 */
object TraitDemo1 {
  def main(args: Array[String]) {
    val obj = new InOriginalState()
    println(obj.isContracted())
    println(obj.isExpanded())
  }
}