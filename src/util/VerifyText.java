package util;

import common.Elements;
import util.Browser;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VerifyText {
	
	public static void run(HashMap<String, String> params){
		WebElement element = Elements.find(params,Browser.Driver);
		Assert.assertEquals(element.getText(),params.get("Text"));
	}

}
