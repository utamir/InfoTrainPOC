/**
 * TODO Add proper copyright notice
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author nzrbfy
 * Private class to cache initialization of Oracle driver
 */
class _database {
	
	public _database() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();		
	}
	
	public Connection GetConnection(String path, String username, String password) throws Exception
	{
		try {
			String connectionURL = "jdbc:oracle:thin:@" + path;
			return DriverManager.getConnection(connectionURL, username, password);
		}
		catch (SQLException e) {
			throw e;	
		} catch (Exception e) {
			throw e;	
		}
	}
}
