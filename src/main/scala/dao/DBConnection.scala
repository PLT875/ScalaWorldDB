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
    
    override def toString() = this.driver + " | " + this.url + " | " + this.username + " | " + this.password
}

/*
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/world"
    val username = "root"
    val password = "Wbgs9906"
    
    var connection:Connection = null
    
    try {
      // Make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
 
      // Create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * FROM CITY WHERE CountryCode = 'GBR' LIMIT 1")
      while ( resultSet.next() ) {
        val name = resultSet.getString("Name")
        val countryCode = resultSet.getString("CountryCode")
        println("Name, CountryCode = " + name + ", " + countryCode)
      }
    } catch {
      case e => e.printStackTrace
    }
    connection.close()*/
