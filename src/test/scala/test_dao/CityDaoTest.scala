package test_dao

import collection.mutable.Stack
import org.scalatest.FlatSpec
import org.scalatest.matchers._
import dao._
import model._

sealed trait NldCities {
	val ams = new City("Amsterdam", "NLD", "Noord-Holland", 731200)
	val rot = new City("Rotterdam", "NLD", "Zuid-Holland", 593321)
    val haa = new City("Haag", "NLD", "Zuid-Holland", 440900)
    val ein = new City("Eindhoven", "NLD", "Noord-Brabant", 201843)
	val til = new City("Tilburg", "NLD", "Noord-Brabant", 193238)
    val bre = new City("Breda", "NLD", "Noord-Brabant", 160398)
	val ape = new City("Apeldoorn", "NLD", "Gelderland", 153491)
	val nij = new City("Nijmegen", "NLD", "Gelderland", 152463)
}

class CityDaoTest extends FlatSpec with Matchers with NldCities {
  /*
   
	  "A Stack" should "pop values in last-in-first-out order" in {
	    val stack = new Stack[Int]
	    stack.push(1)
	    stack.push(2)
	    assert(stack.pop == 3)
	    assert(stack.pop == 1)
	  }
  
  **/
  
}

