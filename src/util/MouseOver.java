package util;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import common.Elements;

public class MouseOver {

	public static void run(HashMap<String, String> params) {
		Actions action = new Actions(Browser.Driver);
		WebElement element = Elements.find(params, Browser.Driver);
	//	action.moveToElement(element).build().perform();
    	action.moveToElement(element).click().perform();
	//	action.moveToElement(element).perform();
	}
    
}
