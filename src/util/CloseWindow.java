package util;

import util.Browser;

public class CloseWindow {
    
	public static void run(Object parmas) {
		if (Browser.Driver != null)
			Browser.Driver.close();
	}
}
