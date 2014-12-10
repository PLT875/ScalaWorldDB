package dao

import java.sql.{ ResultSet, Connection, DriverManager }
import model._
import scala.annotation.tailrec

class CountryLanguageDao {
	def getCountryLanguage(countryName: String): List[CountryLanguage] = {
		val connection : Connection = DBConnection.getConnection
		val resultSet = connection.createStatement.executeQuery(s"SELECT * FROM CountryLanguage WHERE CountryCode = (SELECT CountryCode FROM Country WHERE Name = '$countryName')")
		val countryLanguages = queryCountryLanguageTable(resultSet, Nil)
		connection.close
		countryLanguages
	}
	
	@tailrec
	final def queryCountryLanguageTable(rs : ResultSet, acc : List[CountryLanguage]): List[CountryLanguage] = {      	
		if(!rs.next) acc
		else queryCountryLanguageTable(rs, acc :+ returnCountryLanguage(rs))
	}
	
	private def returnCountryLanguage(rs : ResultSet): CountryLanguage = {
		new CountryLanguage(
			rs.getString("CountryCode"), 
			rs.getString("Language"), 
			rs.getBoolean("IsOfficial"), 
			rs.getDouble("Percentage")
			)    
	}

}
