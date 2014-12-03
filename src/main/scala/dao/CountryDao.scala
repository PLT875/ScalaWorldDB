package dao

import java.sql.{ ResultSet, Connection, DriverManager }
import model._
import scala.annotation.tailrec

class CountryDao {
	
	def getCountries(region: String): List[Country] = {    	
		val connection : Connection = DBConnection.getConnection
		val resultSet = connection.createStatement.executeQuery(s"SELECT * FROM COUNTRY WHERE Region = '$region'")
		val cities = queryCountryTable(resultSet, Nil)
		connection.close
		cities
	}
	
	def getPopulation(name : String) : Int = {
		val connection : Connection = DBConnection.getConnection
		val resultSet = connection.createStatement.executeQuery(s"SELECT Population FROM COUNTRY WHERE Name = '$name'")
		if(resultSet.first) resultSet.getInt("Population") else 0
	}
	
	@tailrec
	final def queryCountryTable(rs : ResultSet, acc : List[Country]): List[Country] = {      	
		if(!rs.next) acc
		else queryCountryTable(rs, acc :+ returnCountry(rs))
	}
	
	private def returnCountry(rs : ResultSet): Country = {
		new Country(
			rs.getString("Name"), 
			rs.getString("Region"), 
			rs.getDouble("SurfaceArea"), 
			rs.getInt("Population")
			)       
	}
}