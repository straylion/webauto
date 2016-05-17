package util;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import common.Elements;

public class DragAndDrop {

	public static void run(HashMap<String, String> params){
		

		HashMap<String,String> paramsFrom = new HashMap<String,String>();
		paramsFrom.put("ID", params.get("From ID"));
		paramsFrom.put("ID Type", params.get("From ID Type"));
		WebElement element = Elements.find(paramsFrom, Browser.Driver);
		
		HashMap<String,String> paramsTo = new HashMap<String,String>();
		paramsTo.put("ID", params.get("To ID"));
		paramsTo.put("ID Type", params.get("To ID Type"));		
		WebElement target = Elements.find(paramsTo, Browser.Driver);
		
		Actions action = new Actions(Browser.Driver);
		action.dragAndDrop(element, target);
		action.build();
		action.perform();
	   
		
	}
	
}
