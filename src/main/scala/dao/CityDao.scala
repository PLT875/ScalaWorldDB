package dao

import java.sql.{ DriverManager, Connection, ResultSet }
import model.City
import scala.annotation.tailrec

class CityDao {
  
	def getCities(countryCode : String): List[City] = {
	  
	    def queryCityTable(rs : ResultSet, acc : List[City]): List[City] = {
	        if(!rs.next) acc
			else queryCityTable(rs, acc :+ returnCity(rs) )
		}
	  
		def returnCity(rs : ResultSet): City = {
		    new City(rs.getString("Name"), rs.getString("CountryCode"), rs.getString("District"), rs.getInt("Population"))       
		}
	  
	    val connection : Connection = DBConnection.getConnection
	    val resultSet = connection.createStatement.executeQuery(s"SELECT * FROM CITY WHERE CountryCode = '$countryCode'")
	    val cities = queryCityTable(resultSet, Nil)
	    connection.close
	    cities   
	}
  
  
	
}