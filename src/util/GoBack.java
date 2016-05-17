package util;

import util.Browser;

public class GoBack {

	public static void run(Object parmas){
		Browser.Driver.navigate().back();
	}
	
}