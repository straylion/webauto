package util;

import util.Browser;

public class Refresh {
	public static void run() {
		Browser.Driver.navigate().refresh();
	}
}
