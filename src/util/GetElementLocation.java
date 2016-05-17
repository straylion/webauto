package util;

import java.util.HashMap;

import common.Elements;
import util.Browser;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class GetElementLocation {

	public static Point run(HashMap<String, String> params){
		WebElement element = Elements.find(params,Browser.Driver); 
        return element.getLocation();
	}
}
