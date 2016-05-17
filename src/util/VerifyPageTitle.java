package util;

import util.Browser;

import java.util.HashMap;

import org.testng.Assert;

public class VerifyPageTitle {
	
	public static void run(HashMap<String, String> params){
		Assert.assertEquals(Browser.Driver.getTitle(),params.get("Title"));
	}
	
}
