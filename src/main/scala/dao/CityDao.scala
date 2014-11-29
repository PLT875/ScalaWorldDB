package dao

import java.sql.{ ResultSet, Connection, DriverManager }
import model._
import scala.annotation.tailrec

class CityDao {
   
	def getCities(countryCode: String): List[City] = {    	
    	val connection : Connection = DBConnection.getConnection
	    val resultSet = connection.createStatement.executeQuery(s"SELECT * FROM CITY WHERE CountryCode = '$countryCode'")
	    val cities = queryCityTable(resultSet, Nil)
	    connection.close
	    cities
	}
	
	@tailrec
    final def queryCityTable(rs : ResultSet, acc : List[City]): List[City] = {      	
		if(!rs.next) acc
		else queryCityTable(rs, acc :+ returnCity(rs))
    }
	
	private def returnCity(rs : ResultSet): City = {
	    new City(
	        rs.getString("Name"), 
	        rs.getString("CountryCode"), 
	        rs.getString("District"), 
	        rs.getInt("Population")
	    )       
	 }
}