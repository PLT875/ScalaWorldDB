package dao

import java.sql.{ DriverManager, Connection }

object DBConnection {
	val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/world"
    var username = "default"
    var password = "default"
    
    def setUsername(): Unit = {
        this.username = readLine("Enter username: ")
    }
    
    def setPassword(): Unit = {
        print("Enter password: ")
    	this.password = new String(System.console.readPassword)
    }
    
    def getConnection(): Connection = {
        DriverManager.getConnection(DBConnection.url, DBConnection.username, DBConnection.password)
	}
    
    override def toString() = this.driver + " | " + this.url + " | " + this.username + " | " + this.password
}
