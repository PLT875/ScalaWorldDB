import java.util.{ Date, Locale }
import java.text.{ DateFormat, SimpleDateFormat }
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
	
	def menu: Unit = {
		println("")
		println("--- Options")
		println("--- a. List Cities By Country")
		println("--- b. List Population Density By Region")
		println("--- c. List Population For Languages By Country")
		println("--- d. List Population By Country District")
		println("--- x. Exit")
		val option = readLine("Enter an option: ")

		try {
			matchChoice(option)
		} catch {
			case e: Throwable => println(e.getMessage)
		}
	}
		
	def matchChoice(choice: String): Unit = choice match {
		case "a" => listCities; menu
		case "b" => listPopulationDensityByRegion; menu
		case "c" => listLanguagePopulation; menu
		case "d" => listPopulationByDistrict; menu
		case "x" => return
		case _ => println(s"Unknown option: $choice"); menu
	}
	
	def listCities: Unit = {
		println("")
		val countryCode = readLine("Enter a country code: ")
		val cityDao = new CityDao
		val cities = cityDao.getCities(countryCode)
		cities.foreach(println)
		println("")
		val yn = readLine("List population by district [y or n]: ")
		if (yn equals "y") {
			val popByDistrict = CityAnalytics.populationByDistrict(cities)
			popByDistrict.foreach { 
				case (key, value) => println("(" + key + ", " + value + ")") 
			}
		}
	}
	
	def listPopulationDensityByRegion: Unit = {
		val region = readLine("Enter a region e.g. Eastern Asia: ")
		val countryDao = new CountryDao
		val countries = countryDao.getCountries(region)
		val popDensity = CountryAnalytics.populationDensity(countries)
		popDensity.sortWith((c1, c2) => c1._2 > c2._2).foreach(println)
	}

	def listLanguagePopulation: Unit = {
		val country = readLine("Enter a country: ")
		val countryLanguageDao = new CountryLanguageDao
		val countryDao = new CountryDao
		val population = countryDao.getPopulation(country)
		val languages = countryLanguageDao.getCountryLanguage(country)
		CountryLanguageAnalytics.languagePopulation(languages, population).foreach(println)
	}

	def listPopulationByDistrict: Unit = {
		val countryCode= readLine("Enter a country code: ")
		val cityDao = new CityDao
		val cities = cityDao.getCities(countryCode);
		val district = readLine("Enter a district: ")
		CityAnalytics.populationByDistrict(cities).filter(x => (x._1.contains(district))).foreach(println)
	}
        
}


