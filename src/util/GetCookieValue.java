package util;

import java.util.HashMap;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

public class GetCookieValue {

	@Test
	public static String run(HashMap<String, String> params){
		
		if(params.get("Cookie Name").equals("ALL")){
			String cookie = Browser.Driver.manage().getCookies().toString();
            System.out.println(cookie);
			return cookie;
		} else {
			Cookie cookie = Browser.Driver.manage().getCookieNamed(params.get("Cookie Name"));
			assert cookie != null : "Error: cookie not found";
            System.out.println(cookie.getValue());
			return cookie.getValue();
		}
		
	}
	
}
