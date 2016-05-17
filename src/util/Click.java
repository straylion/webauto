package util;

import common.Elements;
import util.Browser;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

public class Click {

	public static void run(HashMap<String, String> params) {

		WebElement element = Elements.find(params, Browser.Driver);
		
		/*
		 * try catch is a workaround for a WebDriver bug where
		 * element exists and visible but WebDriver is unable to click it
		 */		
		int iTimeout = 20;
		while (iTimeout > 0)
			try {
				element.click();
				return;
			} catch (org.openqa.selenium.WebDriverException err) {
				iTimeout--;
				if (err.toString().contains("Element is not clickable at point")) {
					if (iTimeout == 0) {
						throw err;
					}
				} else {
					throw err;
				}

			}

	}
}