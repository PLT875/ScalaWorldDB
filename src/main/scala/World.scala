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
    println(s"*** $dateFormat: Getting Started with Scala - World Database Example ***")
    
    // Set user name and password for database connection
    DBConnection.username; DBConnection.password
    
    menu
 
    def menu(): Unit = {
        println("")
        println("--- Options")
        println("--- a. Get List of Cities By Country")
        println("--- x. Exit")
        val option : String = readLine("Enter an option: ")
        matchChoice(option)
        
        def matchChoice(choice: String): Unit = choice match {
            case "a" => listCities
            case "x"=> System.exit(0)
        }
        
        def listCities() : Unit = {
            println("")
            try {
	            val countryCode = readLine("Enter a country code: ")
	            val cityDao = new CityDao
	    	    val cities = cityDao.getCities(countryCode);
	            cities.foreach(println)
            } catch {
            	case e : Throwable => println(e.getMessage)
            } finally {
                menu
            }		
        }
    
    
    }
    
    /*
    
    try {
      
    	
    	println("")
    	println("*** Population by District - Netherlands ***")
    	val popByDistrict = CityAnalytics.populationByDistrict(cities)
    	popByDistrict.foreach { case (key, value) => println ("(" + key + ", " + value + ")") }
    	
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
    	CountryLanguageAnalytics.languagePopulation(cheLanguages, chePopulation).foreach(println)
    	
    	println("*** Population by District - Indonesia ***")
    	val citiesIdn = cityDao.getCities("IDN");
    	val popByDistrictIdn = CityAnalytics.populationByDistrict(citiesIdn).filter(x => (x._1.contains("Java")))
    	popByDistrictIdn.foreach { case (key, value) => println ("(" + key + ", " + value + ")") }
    	
    } catch {
	    case e : Throwable => println(e.getMessage)
	}
	
	**/
   
    
}