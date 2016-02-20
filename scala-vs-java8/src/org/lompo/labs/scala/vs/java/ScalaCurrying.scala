package org.lompo.labs.scala.vs.java

/**
 * @author LOMPO
 */
object ScalaCurrying {
  def main(args:Array[String]) {
    // From a mathematical standpoint, sum of(x,y) can be shaped as sumX of (y)
    def sum(x:Int, y:Int) = x+ y
    val addition = sum(2,5)
    println(addition)
    def sumCurry(x:Int)(y:Int) = x+y
    val addition2 = sumCurry(2)(5)
    println(addition2)
  }
}