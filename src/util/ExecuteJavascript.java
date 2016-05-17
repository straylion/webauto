package util;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;

import util.Browser;

public class ExecuteJavascript {

	public static void run(HashMap<String, String> params){
		JavascriptExecutor js = (JavascriptExecutor) Browser.Driver;
		js.executeScript(params.get("Code"));
	}
	
}
