package org.lompo.labs.scala.vs.java

import scala.io.Source
/**
 * @author LOMPO
 */
object CollectionsWorks1 {
  def main(args:Array[String]) {
    val fileLines = Source.fromFile("C:\\Hypernovae\\Technical\\RD\\All_Java\\java_8_labs\\scala-vs-java8\\src\\org\\lompo\\labs\\scala\\vs\\java\\HelloCastle.scala").getLines().toList
    println(fileLines)
    val markedLongLines
    = fileLines.filter(line => line.length() > 80)
    .map(line => "[[" + line + "]]")
    println(markedLongLines)
  }
}