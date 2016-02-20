package org.lompo.labs.scala.vs.java

/**
 * @author LOMPO
 */
object AnonymousFunctions {
  def main(args:Array[String]) {
    val isShortNewsFeed: String => Boolean = (newsFeed: String) => newsFeed.length() < 18
    
    val isAverageNewsFeed: String => Boolean 
    = new Function1[String, Boolean] {
        def apply(newsFeed:String):Boolean = newsFeed.length() < 60 && newsFeed.length() > 18
    }
  }
}