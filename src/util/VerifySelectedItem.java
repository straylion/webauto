package util;

import common.Elements;
import util.Browser;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class VerifySelectedItem{
  
  public static void run(HashMap<String, String> params){
	System.out.println("Except selectedItem is:"+params);
    WebElement element = Elements.find(params,Browser.Driver);
    WebElement option = new Select(element).getFirstSelectedOption();
    String selectedLabel = option.getText();
    String selectedValue = option.getAttribute("value");
    
    if(params.get("Item Label") != null){
    	Assert.assertEquals(selectedLabel, params.get("Item Label"));
    }
    
    if(params.get("Item Value") != null){
      Assert.assertEquals(selectedValue, params.get("Item Value"));
    }
    
  }
}