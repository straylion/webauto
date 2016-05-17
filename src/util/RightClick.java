package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import common.Elements;
import util.Browser;
import java.util.HashMap;

public class RightClick {

	public static void run(HashMap<String, String> params) {
		// TODO Auto-generated method stub
		WebElement element = Elements.find(params,Browser.Driver);
		Actions action = new Actions(Browser.Driver);
		action.contextClick(element).perform();
	}

} 