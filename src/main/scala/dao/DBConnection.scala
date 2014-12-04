package dao

import java.sql.{ DriverManager, Connection }

object DBConnection {
	val driver = "com.mysql.jdbc.Driver"
	val url = "jdbc:mysql://localhost:3306/world"
	lazy val username : String = readLine("Enter username: ")
	lazy val password : String = new String(System.console.readPassword("Enter password: "))
	
	def getConnection : Connection = {
		Class.forName(DBConnection.driver)
		DriverManager.getConnection(DBConnection.url, DBConnection.username, DBConnection.password)
	}
	
	override def toString = this.driver + " | " + this.url + " | " + this.username + " | " + this.password
}
