package org.lompo.labs.scala.vs.java

/**
 * @author LOMPO
 */
object FirstClassFunction {
  def main(args:Array[String]) {
    def doesNewsContainsFunctional(newsFeed: String) : Boolean = newsFeed.contains("functional")
    def isAverageLenghtNews(newsFeed: String) : Boolean = newsFeed.length() >= 20
  
    var newsFeeds = List(
      "Mr Abrash just created a new purely functional language",
      "The Art of computer programming Vol 7 about to be released soon!!!!",
      "Masm EOL!",
      "functional bliss"
    )
    
    println("News feed about functional programming....")
    newsFeeds.filter(doesNewsContainsFunctional).foreach(println)
    println()
    println("Average length news feeds...")
    newsFeeds.filter(isAverageLenghtNews).foreach(println) 
  }
}