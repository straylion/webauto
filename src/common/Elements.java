package common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class Elements {

	public static WebElement find(HashMap<String, String> params, WebDriver Driver) {

		WebElement foundElement = null;

		switch (params.get("ID Type")) {
		case "Class Name":
			foundElement = Driver.findElement(By.className(params.get("ID")));
			break;
		case "Css Selector":
			foundElement = Driver.findElement(By.cssSelector(params.get("ID")));
			break;
		case "ID":
			foundElement = Driver.findElement(By.id(params.get("ID")));
			break;
		case "Link Text":
			foundElement = Driver.findElement(By.linkText(params.get("ID")));
			break;
		case "XPath":
			foundElement = Driver.findElement(By.xpath(params.get("ID")));
			break;
		case "Name":
			foundElement = Driver.findElement(By.name(params.get("ID")));
			break;
		case "Partial Link Text":
			foundElement = Driver.findElement(By.partialLinkText(params.get("ID")));
			break;
		case "Tag Name":
			foundElement = Driver.findElement(By.tagName(params.get("ID")));
			break;
		//Property,default:xpath, get from properties
		case "Property":
            foundElement = Driver.findElement(By.xpath(Elements.getP(params.get("ID"))));
            break;
		default:
			foundElement = Driver.findElement(By.xpath(Elements.getP(params.get("ID"))));
		}

        //hightlight element
        if(foundElement != null){
        //    final JavascriptExecutor js = (JavascriptExecutor) Driver;
      	//	js.executeScript("element = arguments[0];" + "original_style = element.getAttribute('style');"
        // 	       + "element.setAttribute('style', original_style + \";"
        //	       + "background: yellow; border: 2px solid red;\");"
        // 	       + "setTimeout(function(){element.setAttribute('style', original_style);}, 1000);", foundElement);
        	return foundElement;
        } else {
            return null;
        }

	}
    
    public static List<WebElement> findAll(HashMap<String, String> params, WebDriver Driver){
		List<WebElement> foundElements;
		switch (params.get("ID Type")) {
		case "Class Name":
			foundElements = Driver.findElements(By.className(params.get("ID")));
			break;
		case "Css Selector":
			foundElements = Driver.findElements(By.cssSelector(params.get("ID")));
			break;
		case "ID":
			foundElements = Driver.findElements(By.id(params.get("ID")));
			break;
		case "Link Text":
			foundElements = Driver.findElements(By.linkText(params.get("ID")));
			break;
		case "XPath":
			foundElements = Driver.findElements(By.xpath(params.get("ID")));
			break;
		case "Name":
			foundElements = Driver.findElements(By.name(params.get("ID")));
			break;
		case "Partial Link Text":
			foundElements = Driver.findElements(By.partialLinkText(params.get("ID")));
			break;
		case "Tag Name":
			foundElements = Driver.findElements(By.tagName(params.get("ID")));
			break;
		//Property,default:xpath, get from properties
		case "Property":
            foundElements = Driver.findElements(By.xpath(Elements.getP(params.get("ID"))));
            break;
		default:
			foundElements = Driver.findElements(By.xpath(Elements.getP(params.get("ID"))));
		}
		return foundElements;
	}

	/*
	 * Read properties
	 */
	public static Properties readProperties(String filePath) {

		Properties p = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(filePath));
			p.load(in);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}

	/*
	 * read key-value (param-pr)
	 * 
	 */
	public static String getP(String param) {
		String filePath = "\\\\testmech\\WebAuto\\elementpath.properties";
		Properties p = readProperties(filePath);
		String pr = p.getProperty(param);
		return pr;
	}

}