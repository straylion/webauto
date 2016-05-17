package util;

import common.Elements;
import common.Wait;
import util.Browser;
import java.util.HashMap;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyElementState{
  
  public static void run(HashMap<String, String> params){

    WebElement element = Elements.find(params,Browser.Driver);
    
    
	
	String eEnable="";
	if(element.isEnabled()){
		eEnable="true";
	}else{
		eEnable="false";
	}
	String eVisible="";
	if(element.isEnabled()){
		eVisible="true";
	}else{
		eVisible="false";
	}
	if(params.get("Is Visible") != null){
    	Assert.assertEquals(true,eVisible==params.get("Is Visible"));   
    }
	
    if(params.get("Is Enable") != null){
      Assert.assertEquals(true,eEnable==params.get("Is Enable"));
    }
    
    
    
  }

} 