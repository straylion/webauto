package util;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.Browser;
import common.Elements;

public class DoubleClick {
	
	public static void run(HashMap<String, String> params){
		
		WebElement element = Elements.find(params, Browser.Driver);
		Actions action = new Actions(Browser.Driver);
		action.doubleClick(element);
	    action.perform();
		
	}
	
}
