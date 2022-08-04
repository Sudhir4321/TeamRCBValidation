Package ExtractJSONEx;

import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParserException;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TeamRCB {

	public static int getForeign (JSONArray teamarray)
	{
		int count=0;
		for (int i=0; i < teamarray.size(); i++)
			{
				JSONObject player = (JSONObject) teamarray.get(i);
				String country = (String) player.get("country");
				if (!country.equals("India"))
					{
						count++;
					}
			}
			return count;
	}
	public static int getKeeper (JSONArray teamarray)
		{
		int count=0;
		for (int i=0; i < teamarray.size(); i++)
			{
				JSONObject player = (JSONObject) teamarray.get(i);
				String wicketKeper = (String) player.get("role");
				if (wicketKeper.equals("Wicket Keeper"))
					{
						count++;
					}
			}
			return count;			
		}
@Test (priority=1)
public void verifyForeignPlayer () throws IOException, ParseException
{
	JSONArray addrerssarray = jsonExtractionValidation.getDetails(".\\JsonObject\\CricketRCBTeam.json");
	int count_country = getForeign(addrerssarray);
	Assert.assertEquals(4,count_country);
	
}
@Test (priority=2)
public void verifyKeeper () throws IOException, ParseException
{
	JSONArray addrerssarray = jsonExtractionValidation.getDetails(".\\JsonObject\\CricketRCBTeam.json");
	int count_keeper = getKeeper(addrerssarray);
	Assert.assertEquals(1,count_keeper);
}

}