/*
* TODO Add proper copyright notice
*/
package trans;

/**
 * @author nzrbfy
 * Utility helper class 
 */
public class Utils {

	/**
	 * Converts UNDER_SCORE string resresentation into it CamelCase
	 * @param s - UNDER_SCORE string
	 * @return CamelCase string
	 */
	public static String ToCamelCase(String s){
		   String[] parts = s.split("_");
		   String camelCaseString = "";
		   for (String part : parts){
		      camelCaseString = camelCaseString + _toProperCase(part);
		   }
		   return camelCaseString;
		}

	private static String _toProperCase(String s) {
		    return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
		}
	
}
