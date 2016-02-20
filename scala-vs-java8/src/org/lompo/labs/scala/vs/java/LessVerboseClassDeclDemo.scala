package org.lompo.labs.scala.vs.java

/**
 * @author LOMPO
 */
object LessVerboseClassDeclDemo {
  def main(args:Array[String]) {
    val javaLanguageCourse = new TrainingCourse("The Java Programming Language", 5)
    
    // Duration passes to six days
    javaLanguageCourse.durationInDays += 1
    println( javaLanguageCourse.title + " is taught in " + javaLanguageCourse.durationInDays + " days")
  }
}