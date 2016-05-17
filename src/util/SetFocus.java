package util;

import common.Elements;
import java.util.HashMap;
import util.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SetFocus{
  
  public static void run(HashMap<String, String> params){
    WebElement element = Elements.find(params,Browser.Driver);

    if(element.getTagName() == "input"){
       element.sendKeys("");
    } 
    else{
       new Actions(Browser.Driver).moveToElement(element).perform();
    
    }
    
  }
}