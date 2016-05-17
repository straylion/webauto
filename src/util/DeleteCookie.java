package util;

import java.util.HashMap;

import common.Wait;
import util.Browser;

public class DeleteCookie {
	
	public static void run(HashMap<String, String> params){
		if(params.get("Cookie Name").equals("ALL")){      
			System.out.println("Cookie Name == ALL");
			System.out.println("Before Cookies:"+Browser.Driver.manage().getCookies());
			Browser.Driver.manage().deleteAllCookies();
			System.out.println("After Cookies:"+Browser.Driver.manage().getCookies());					
		} else {
			System.out.println("Other Cookie Name == "+params.get("Cookie Name"));
			System.out.println("Before Cookies:"+Browser.Driver.manage().getCookies());
			Browser.Driver.manage().deleteCookieNamed(params.get("Cookie Name"));
			System.out.println("After Cookies:"+Browser.Driver.manage().getCookies());			
		}
	}
	
}
