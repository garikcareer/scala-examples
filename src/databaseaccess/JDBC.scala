package databaseaccess

import java.sql.{Connection, DriverManager, SQLException, Statement}

object JDBC extends App {
  private val driver ="com.mysql.cj.jdbc.Driver"
  private val url = "jdbc:mysql://localhost:3306/warehouseDB"
  private val username = "root"
  private val password = "admin"

  try{
    Class.forName(driver)
    val connection:Connection = DriverManager.getConnection(url, username, password)
    println("Connected to " + url + " successfully.\n")
    val statement: Statement = connection.createStatement()

    println("Retrieving Data from warehouse table from warehouse DB")
    val resultSet = statement.executeQuery("SELECT name, location FROM warehouse")
    while(resultSet.next()){
      val name = resultSet.getString("name")
      val location = resultSet.getString("location")
      println("Warehouse | name: " + name + " location: " + location)
    }

    connection.close()
  }
  catch {
    case sqlException: SQLException =>
      println("SQLException: " + sqlException)
      println("SQLState: " + sqlException.getSQLState)
      println("Vendor Error: " + sqlException.getErrorCode)
    case exception: Exception => exception.printStackTrace()
  }
}
