package util;

import java.util.HashMap;

import util.Browser;

public class GetPageSource {

	public static String run(HashMap<String, String> params){
		return Browser.Driver.getPageSource();
	}
}
