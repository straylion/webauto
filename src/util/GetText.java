package util;

import java.util.HashMap;

import common.Elements;
import util.Browser;

import org.openqa.selenium.WebElement;

public class GetText {
	
	public static String run(HashMap<String, String> params){
		WebElement element = Elements.find(params,Browser.Driver); 
        return element.getText();
	}  
   
}
