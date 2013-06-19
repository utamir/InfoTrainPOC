/*
* TODO Add proper copyright notice
*/
package trans;

import java.io.*;
import java.sql.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

/**
 * @author nzrbfy
 * Xml serialization services 
 */
public class XmlSerializer {
	

	/**
	 * Serializes ResultSet into proper generic Xml respresentation.
	 * @param rs ResultSet to serialize
	 * @param tag Single item encapsulation tag.
	 * @return Xml representation of the given ResultSet.
	 */
	public static String GetXml(ResultSet rs, String tag) throws Exception{
		Document result =_serialize(rs, tag);
		if(result != null) {
			TransformerFactory factory = TransformerFactory.newInstance();  
	        Transformer transformer = factory.newTransformer();  
	  
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");  
	  
	  
	        StringWriter sw = new StringWriter();  
	        StreamResult res = new StreamResult(sw);  
	        DOMSource source = new DOMSource(result);  
	        transformer.transform(source, res);  
	        String xmlString = sw.toString();  
		return xmlString;
		} else { 
			return null;
		}
	}
	

private static Document _serialize(ResultSet rs, String tag) throws Exception {
	try {
		
	DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	Document doc = docBuilder.newDocument();
	
		ResultSetMetaData rsmd = rs.getMetaData();
		Node root = doc.createElement("result");
		doc.appendChild(root);
		
	    while(rs.next()) {
	      int numColumns = rsmd.getColumnCount();
	      Node obj = doc.createElement(tag);

	      for (int i=1; i<numColumns+1; i++) {
	    	String columnName = Utils.ToCamelCase(rsmd.getColumnName(i));	        
	        
	    	Node n = doc.createElement(columnName);
    		
	        switch(rsmd.getColumnType(i)){
	        case java.sql.Types.BIGINT:	    
	        case java.sql.Types.INTEGER:	   
	        case java.sql.Types.SMALLINT:
	        case java.sql.Types.TINYINT:
	        case java.sql.Types.BIT:
	        case java.sql.Types.NUMERIC:
	        	int ival = rs.getInt(i);
	        	if(!rs.wasNull()) {
	        		n.setTextContent(String.valueOf(ival));
	        		obj.appendChild(n);
	        	}
        		break;
        	case java.sql.Types.BOOLEAN:
        		Boolean bval = rs.getBoolean(i);
        		if(!rs.wasNull()) {
	        		n.setTextContent(String.valueOf(bval));
	        		obj.appendChild(n);
        		}
	        	break;
	        case java.sql.Types.DOUBLE:	   
	        	Double dval = rs.getDouble(i);
	        	if(!rs.wasNull()) {
	        		n.setTextContent(String.valueOf(dval));
	        		obj.appendChild(n);
	        	}
	        	break;
	        case java.sql.Types.FLOAT:	 
	        	Float fval = rs.getFloat(i);
	        	if(!rs.wasNull()) {
	        		n.setTextContent(String.valueOf(fval));
	        		obj.appendChild(n);
	        	}
		       	break;
		    case java.sql.Types.NVARCHAR:
		    case java.sql.Types.NCHAR:	    
		    	String nsval = rs.getNString(i);
		    	if(!rs.wasNull()) {
	        		n.setTextContent(String.valueOf(nsval));
	        		obj.appendChild(n);
		    	}
			    break;    
		    case java.sql.Types.VARCHAR:
		    case java.sql.Types.CHAR:
		    	String sval = rs.getString(i);
		    	if(!rs.wasNull()) {
	        		n.setTextContent(String.valueOf(sval));
	        		obj.appendChild(n);
		    	}
			    break;
		    case java.sql.Types.DATE:
		    	Date date = rs.getDate(i);
		    	if(!rs.wasNull()){
	        		n.setTextContent(String.valueOf(date.toString()));
	        		obj.appendChild(n);
		    	}
			    break;
		    case java.sql.Types.TIMESTAMP:
		    	Timestamp ts = rs.getTimestamp(i);
		    	if(!rs.wasNull()){
	        		n.setTextContent(String.valueOf(ts.toString()));
	        		obj.appendChild(n);
		    	}
			    break;
		    case java.sql.Types.TIME:	        
		    	Time time =  rs.getTime(i);
		    	if(!rs.wasNull()){
	        		n.setTextContent(String.valueOf(time.toString()));
	        		obj.appendChild(n);
		    	}
			    break;
		    default:	
		    	//TODO: Leave it by now to assure that all types are covered.
		    	throw new Exception("Parser of "+ rsmd.getColumnTypeName(i)+" is not implemented [Column: "+rsmd.getColumnName(i)+"].");
	        }	        
		        
	      }
	      root.appendChild(obj);
		  }
	    return doc;
		} catch (SQLException seq) {
			throw new Exception("Sql parsing exception "+seq);
		} catch (Exception e) {
			throw new Exception("General parsing exception "+e);
		}
	    
	}
	
	
}
