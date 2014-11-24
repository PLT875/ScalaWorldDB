import java.util.{Date, Locale}
import java.text.{DateFormat, SimpleDateFormat}
import java.sql.{ DriverManager, Connection, ResultSet }
import dao._
import model.City
import analytics.CityAnalytics

/*
 * Author: Peter Tran
 * 
 * This application is for learning purposes, as an introduction to Scala.
 * 
 * Resources
 * ++ MySQL world database: http://dev.mysql.com/doc/index-other.html
 * ++ Functional Programming Principles in Scala: https://www.coursera.org/course/progfun
 * ++ Programming in Scala, First Edition: http://www.artima.com/pins1ed/
 * 
 */

object World extends App {
	val dateFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date)
    println(s"*** $dateFormat: Getting Started with Scala - World Database ***")
    
    // Set user name and password for database connection
    DBConnection.setUsername; DBConnection.setPassword
    try {
    	val cityDao = new CityDao
    	// val cities = cityDao.getCities("NLD");
    	
    	val connection : Connection = DBConnection.getConnection
	    val resultSet = connection.createStatement.executeQuery(s"SELECT * FROM CITY WHERE CountryCode = 'NLD'")
	    val cities = cityDao.queryCityTable(resultSet, Nil)
	    connection.close
    	val popByDistrict = CityAnalytics.populationByDistrict(cities)
    	popByDistrict.foreach { case (key, value) => println (key + " --> " + value) }
    	// cities.foreach(println)
    } catch {
	    case e : Throwable => println(e.getMessage)
	}
    
    
}