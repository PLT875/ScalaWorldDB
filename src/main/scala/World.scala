import java.util.{Date, Locale}
import java.text.{DateFormat, SimpleDateFormat}
import java.sql.{ DriverManager, Connection, ResultSet }
import dao._
import model._
import analytics._

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
    DBConnection.username; DBConnection.password
    try {
        println("")
        println("*** Cities - Netherlands ***")
    	val cityDao = new CityDao
    	val cities = cityDao.getCities("NLD");
    	cities.foreach(println)
    	
    	println("")
    	println("*** Population by District - Netherlands ***")
    	val popByDistrict = CityAnalytics.populationByDistrict(cities)
    	popByDistrict.foreach { case (key, value) => println (key + " --> " + value) }
    	
    	println("")
    	println("*** Population Density of Countries in Southeast or Eastern Asia ***")
    	val countryDao = new CountryDao
    	val countries = countryDao.getCountries("'Southeast Asia' or Region = 'Eastern Asia'")
    	val popDensity = CountryAnalytics.populationDensity(countries)
    	popDensity.sortWith((c1, c2) => c1._2 > c2._2).foreach(println)
    	
    	println("")
    	println("*** Switzerland Statistics ***")
    	val chePopulation = countryDao.getPopulation("Switzerland")
    	println(s"Population: $chePopulation")
    	
    	val countryLanguageDao = new CountryLanguageDao
    	val cheLanguages = countryLanguageDao.getCountryLanguage("CHE")

    	println("Population of Spoken Languages")
    	val langPer = cheLanguages.map(cl => (cl.language, cl.percentage))
    	langPer.map( cl => (cl._1, (cl._2 / 100) * chePopulation)).foreach(println)
    	
    	
    } catch {
	    case e : Throwable => println(e.getMessage)
	}
   
    
}