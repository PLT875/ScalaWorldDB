import java.util.{Date, Locale}
import java.text.{DateFormat, SimpleDateFormat}
import dao._
import model._

/*
 * Author: Peter Tran
 * 
 * This application is for learning purposes, as an introduction to Scala.
 * Uses the "world" MySQL database, download available at http://dev.mysql.com/doc/index-other.html
 * 
 */

object World extends App {
	val dateFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date)
    println(s"*** $dateFormat: Getting Started with Scala - World Database ***")
    
    // Set user name and password for database connection
    DBConnection.setUsername; DBConnection.setPassword
    try {
    	val cityDao = new CityDao
    	val cities = cityDao.getCities
    	cities.foreach(println)
    } catch {
	    case e : Throwable => println(e.getMessage)
	}
    
    
}