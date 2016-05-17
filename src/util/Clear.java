package util;

import common.Elements;
import util.Browser;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

public class Clear {

	public static void run(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		element.clear();
	}
}