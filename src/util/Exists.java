package util;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import common.Elements;

public class Exists {

	public static void run(HashMap<String, String> params){
		List<WebElement> elements = Elements.findAll(params, Browser.Driver);
		String str = params.get("Number of Matches");
		if( null == str || "".equals(str) || "null".equals(str)){

			//assert elements.size() > 0 : "Error element: " + params.get("ID") + " was not found.";	
			Assert.assertEquals(elements.size()>0,true);
			

		} else {
			//assert elements.size() == Integer.parseInt(params.get("Number of Matches")): "Error element: " + params.get("ID") + " was not found expected number of times: " + str + ".  It was found: " + elements.size() + " times.";
			Assert.assertEquals(elements.size(),Integer.parseInt(params.get("Number of Matches")));
		}
	}
	
}
