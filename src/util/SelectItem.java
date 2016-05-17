package util;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import common.Elements;

public class SelectItem {

	public static void run(HashMap<String, String> params){
		System.out.println(params);
		
		WebElement element = Elements.find(params,Browser.Driver);
		
		System.out.println(params);
		
		if(params.get("Visible Text") != null){
			new Select(element).selectByVisibleText(params.get("Visible Text"));
		} else if(params.get("Value") != null){
			new Select(element).selectByVisibleText(params.get("Value"));
		} else if(params.get("Index") != null){
			new Select(element).selectByVisibleText(params.get("Index"));
		}
		
	}
	
}
