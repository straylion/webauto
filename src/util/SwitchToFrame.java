package util;

import java.util.HashMap;
import util.Browser;

public class SwitchToFrame {

	public static void run(HashMap<String, String> params) {
		Browser.Driver.switchTo().frame(params.get("ID or Name"));
	}
	
}
