Package ExtractJSONEx;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParserException;

public class jsonExtractionValidation {
public static JSONArray getDetails(String loc) throws IOException, ParseException {
	
	JSONParser jsonparser = new JSONParser();
	FileReader reader = new FileReader(loc);
	Object obj = jsonparser.parse(reader);
	JSONObject tempobj = (JSONObject) obj;
	
	String teamName = (String) tempobj.get("name");
	String location = (String) tempobj.get("location");
	
	JSONArray teamarray = (JSONArray) teamobj.get("player");
	
	for(int i = 0; i< teamarray.size(); i++){
	JSONObject address = (JSONObject) teamarray.get(i);
	String name = (String) address.get("name");
	String country = (String) address.get("country");
	String role = (String) address.get("role");
	String price_in_crores= (String) address.get("price-in-crore");
	}
	return teamarray;
    }
}