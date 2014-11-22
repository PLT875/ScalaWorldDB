import java.util.{Date, Locale}
import java.text.{DateFormat, SimpleDateFormat}
import dao._

/*
 * Author: Peter L Tran
 * This application is for learning purposes, as an introduction to Scala and
 * uses the "world" MySQL database: http://dev.mysql.com/doc/index-other.html
 */

object World extends App {
	val dateFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date)
    println(s"$dateFormat: Getting Started with Scala - World Database")
    
    // Set user name and password for database connection
    DBConnection.setUsername; DBConnection.setPassword
   
}