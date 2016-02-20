package org.lompo.labs.scala.vs.java

/**
 * @author LOMPO
 */
trait Expandable {
  var length: Int = 100
  def isExpanded() = length > 100
  def isContracted() = length < 100
  
}