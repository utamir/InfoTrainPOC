/**
 * TODO Add proper copyright notice
 */
package dao;

import java.sql.*;
import java.util.logging.*;

import javax.ws.rs.core.*;
import com.sun.jersey.api.core.*;

import trans.*;

/**
 * @author nzrbfy
 * Abstract implementation of DAL. * 
 */

public abstract class DatabaseService {
	private String _dpath, _dun, _dpwd;
	private void _setParams(){		
		_dpath = (String)cfg.getProperty("DatabasePath");
		_dun = (String)cfg.getProperty("DatabaseUsername");
		_dpwd = (String)cfg.getProperty("DatabasePassword");		
	}
	
	private _database _db = null;
	
	/**
	 * Gets ready for use connection to the database.
	 * Should be used within Maven web services context, since using @Context globals. 
	 * @return Ready to use database connection/
	 * @throws Exception
	 */
	protected Connection $Db() throws Exception{
		if(_db == null) _db = new _database();		
		_setParams();
		return _db.GetConnection(_dpath, _dun, _dpwd);
	}
	
	/**
	 * Responses the result of {@code rs} execution, serialized based on {@code type}. Every single item will be encapsulated into property of type defined by {@code itemTag}
	 * @param rs The recordset to serialize
	 * @param itemTag Single item encapsulating tag
	 * @param type The content type to serialize to.
	 * @return Serialized result of the {@code rs} execution.
	 */
	protected Response $Response(ResultSet rs, String itemTag, String type) {
		try {
			Object result = null;
			String prod = MediaType.WILDCARD;
			if(type.equalsIgnoreCase("json")) {
				result = JsonSerializer.GetJson(rs, itemTag);
				prod = MediaType.APPLICATION_JSON;
			} else if (type.equalsIgnoreCase("xml")) {
				result = XmlSerializer.GetXml(rs, itemTag);
				prod = MediaType.APPLICATION_XML;
			}
				
			return Response.ok(result, prod).build();
		} catch (Exception e) {
			return $Response(e);
		}
	}
	
	/**
	 * Responses the result of {@code sql} SQL statement, serialized based on {@code type}. Every single item will be encapsulated into property of type defined by {@code itemTag}
	 * @param sql The recordset to serialize
	 * @param itemTag Single item encapsulating tag
	 * @param type The content type to serialize to.
	 * @return Serialized result of the {@code sql} SQL statement execution execution.
	 */
	protected Response $Response(String sql, String itemTag, String type) {
		try {
			PreparedStatement ps = $Db().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			return $Response(rs, itemTag, type);
		} catch (Exception e) {
			return $Response(e);
		}
	}
	
	/**
	 * Responses the result of {@code e} exception. This response will provide 500 error and write into out console and {@code dao.DatabaseService} log
	 * @param e Exception to log.
	 * @return 500 error response.
	 */
	protected Response $Response(Exception e) {
		_logger.log(Level.SEVERE, e.getMessage());
		java.lang.System.out.println(e); //DBG
		return Response.serverError().build();
	}
	
	private static Logger _logger = Logger.getLogger("dao.DatabaseService");
	
	@Context 
	ResourceConfig cfg;
}
