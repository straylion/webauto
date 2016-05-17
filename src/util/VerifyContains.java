package util;

import java.util.HashMap;

import org.testng.Assert;

public class VerifyContains {

	public static void run(HashMap<String, String> params) {
		String actual =	params.get("Actual");
		String expected = params.get("Expected");
		Assert.assertTrue(actual.contains(expected));
	}
	
}
