package dao

import java.sql.ResultSet
import model.City
import scala.annotation.tailrec

class CityDao {
   
	@tailrec
    final def queryCityTable(rs : ResultSet, acc : List[City]): List[City] = {      	
		if(!rs.next) acc
		else queryCityTable(rs, acc :+ returnCity(rs) )
    }
	
	def returnCity(rs : ResultSet): City = {
	    new City(
	        rs.getString("Name"), 
	        rs.getString("CountryCode"), 
	        rs.getString("District"), 
	        rs.getInt("Population")
	    )       
	 }
}