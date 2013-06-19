/**
 * TODO Add proper copyright notice
 */
package trans;

import java.sql.*;
import java.util.UUID;

import com.google.gson.*;

/**
 * @author nzrbfy
 * Json serialization services 
 */
public class JsonSerializer{
	
	/**
	 * Serializes ResultSet into proper generic Json respresentation.
	 * @param rs ResultSet to serialize
	 * @param tag Single item encapsulation tag.
	 * @return Json representation of the given ResultSet.
	 */
	public static String GetJson(ResultSet rs, String tag){
		Gson gson = new Gson();
		return gson.toJson(_serialize(rs, tag));		
	}
	
	/**
	 * Serializes Java object into its Json representation.
	 * @param o Java object to serialize.
	 * @return Json representation of the given object.
	 */
	public static String GetJson(Object o){
		Gson gson = new Gson();
		return gson.toJson(o);
	}

	private static JsonElement _serialize(ResultSet rs, String tag) {
		JsonObject res = new JsonObject();
		JsonArray json = new JsonArray();
		try {
		ResultSetMetaData rsmd = rs.getMetaData();

	    while(rs.next()) {	    	
	      int numColumns = rsmd.getColumnCount();
	      JsonObject obj = new JsonObject();

	      for (int i=1; i<numColumns+1; i++) {
	    	String columnName = Utils.ToCamelCase(rsmd.getColumnName(i));	        
	        
	     switch(rsmd.getColumnType(i)){
	        case java.sql.Types.BIGINT:	    
	        case java.sql.Types.INTEGER:	   
	        case java.sql.Types.SMALLINT:
	        case java.sql.Types.TINYINT:
	        case java.sql.Types.BIT:
	        case java.sql.Types.NUMERIC:
	        	int ival = rs.getInt(i);
	        	if(!rs.wasNull()) {
	        		obj.addProperty(columnName, ival);
	        	}
        		break;
        	case java.sql.Types.BOOLEAN:
        		Boolean bval = rs.getBoolean(i);
        		if(!rs.wasNull()) {
	        		obj.addProperty(columnName, bval);
        		}
	        	break;
	        case java.sql.Types.DOUBLE:	   
	        	Double dval = rs.getDouble(i);
	        	if(!rs.wasNull()) {
	        		obj.addProperty(columnName, dval);
	        	}
	        	break;
	        case java.sql.Types.FLOAT:	 
	        	Float fval = rs.getFloat(i);
	        	if(!rs.wasNull()) {
	        		obj.addProperty(columnName,fval);
	        	}
		       	break;
		    case java.sql.Types.NVARCHAR:
		    case java.sql.Types.NCHAR:	    
		    	String nsval = rs.getNString(i);
		    	if(!rs.wasNull()) {
	        		obj.addProperty(columnName, nsval);
		    	}
			    break;    
		    case java.sql.Types.VARCHAR:
		    case java.sql.Types.CHAR:
		    	String sval = rs.getString(i);
		    	if(!rs.wasNull()) {
	        		obj.addProperty(columnName, sval);
		    	}
			    break;
		    case java.sql.Types.DATE:
		    	Date date = rs.getDate(i);
		    	if(!rs.wasNull()){
		    		obj.addProperty(columnName, date.toString());
		    	}
			    break;
		    case java.sql.Types.TIMESTAMP:
		    	Timestamp ts = rs.getTimestamp(i);
		    	if(!rs.wasNull()){
		    		obj.addProperty(columnName, ts.toString());
		    	}
			    break;
		    case java.sql.Types.TIME:	        
		    	Time time =  rs.getTime(i);
		    	if(!rs.wasNull()){
		    		obj.addProperty(columnName,time.toString());
		    	}
			    break;
		    case java.sql.Types.BINARY:
		    case java.sql.Types.VARBINARY:
		    	//this is guid, but we will serialize as string
		    	//TODO: Find a way to differ GUIDS from any other binary blobs
		    	byte[] bytes = (byte[])rs.getObject(i);			    	
		    	if(!rs.wasNull()){
		    		UUID gval = UUID.nameUUIDFromBytes(bytes);
		    		obj.addProperty(columnName,gval.toString());
		    	}
		    	break;
		    default:	
		    	//TODO: Leave it by now to assure that all types are covered.
		    	throw new JsonParseException("Parser of "+ rsmd.getColumnTypeName(i)+"("+rsmd.getColumnType(i)+") is not implemented [Column: "+rsmd.getColumnName(i)+"].");
	        }	        
		        
	      }
	      JsonObject root = new JsonObject();
	    	root.add(tag, obj);
	        json.add(root);
		  }
		} catch (SQLException seq) {
			throw new JsonParseException("Sql parsing exception "+seq);
		} catch (Exception e) {
			throw new JsonParseException("General parsing exception "+e);
		}
		res.add("result", json);
		
	    return res;
	}

}
