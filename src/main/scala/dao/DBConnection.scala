package dao

import java.sql.{ DriverManager, Connection }

object DBConnection {
	val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/world"
    var username : String = "default"
    var password : String = "default"
    
    def setUsername(): Unit = {
        this.username = readLine("Enter username: ")
    }
    
    def setPassword(): Unit = {
        print("Enter password: ")
    	this.password = new String(System.console.readPassword)
    }
    
    def getConnection(): Connection = {
        Class.forName(DBConnection.driver)
        DriverManager.getConnection(DBConnection.url, DBConnection.username, DBConnection.password)
	}
    
    override def toString() = this.driver + " | " + this.url + " | " + this.username + " | " + this.password
}
