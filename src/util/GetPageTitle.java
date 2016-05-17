package util;

import java.util.HashMap;

import util.Browser;

public class GetPageTitle {

	public static String run(HashMap<String, String> params){
		return Browser.Driver.getTitle();
	}
}
