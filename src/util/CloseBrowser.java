package util;

import util.Browser;

public class CloseBrowser {

	public static void run(Object parmas) {
        if (Browser.Driver != null)
            try {
                Browser.Driver.quit();
            } catch (Exception anException) {
                System.out.println("Closeed All Browser and Killed task");
            }
	}
}
