package util;

import java.util.HashMap;

import util.Browser;

public class NavigateToURL {

	public static void run(HashMap<String, String> params){
		
		if (params.get("URL") != null) {
			if ((params.get("URL")).startsWith("http://")
					|| (params.get("URL")).startsWith("https://")) {
				Browser.Driver.navigate().to(params.get("URL"));
			} else {
				Browser.Driver.navigate().to("http://" + params.get("URL"));
			}

		}
		
	}
	
}
