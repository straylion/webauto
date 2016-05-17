package util;

import common.Elements;
import util.Browser;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Verifies {
	// Assert.assertEquals(actual, expected);
	// Attribute
	public static void attribute(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.getAttribute(params.get("Attribute Name")), params.get("Value"));
        System.out.println("element " + params.get("ID") + " \'s " + params.get("Attribute Name") + "is" + params.get("Value"));
	}

	// Page Title
	public static void pageTitle(HashMap<String, String> params) {
		Assert.assertEquals(Browser.Driver.getTitle(), params.get("Title"));
        System.out.println("Browser Title is " + params.get("Title"));
	}
    
    public static void pageTitleContain(HashMap<String, String> params) {
		Assert.assertTrue(Browser.Driver.getTitle().contains(params.get("Title")));
        System.out.println("Browser Title contains " + params.get("Title"));
	}
    
	// Text
	public static void text(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.getText(), params.get("Text"));
        System.out.println("element " + params.get("ID") + "\'s Text is" + params.get("Text"));
	}
    
    public static void textContain(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertTrue(element.getText().contains(params.get("Text")));
        System.out.println("element " + params.get("ID") + "\'s Text contains" + params.get("Text"));
	}

	// Current URL
	public static void currentUrl(HashMap<String, String> params) {
		Assert.assertEquals(Browser.Driver.getCurrentUrl(), params.get("Value"));
        System.out.println("Current URL is " + params.get("Value"));
	}

	// CheckBox
	public static void checkbox(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.isSelected(), params.get("Is Checked").equals("true"));
        System.out.println("Checkbox " + params.get("ID") + "is Checked.");
	}

	// Exist
	public static void isExisted(HashMap<String, String> params) {
		List<WebElement> elements = Elements.findAll(params, Browser.Driver);
		Assert.assertNotEquals(elements.size(), 0);
		System.out.println("element " + params.get("ID") + " is existed.");
	}

	// Not Exist
	public static void notExisted(HashMap<String, String> params) {
		List<WebElement> elements = Elements.findAll(params, Browser.Driver);
		Assert.assertEquals(elements.size(), 0);
		System.out.println("element " + params.get("ID") + " is not existed.");
	}
    
    // Enabled
	public static void isEnable(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.isEnabled(), true);
        System.out.println("element " + params.get("ID") + " is enabled.");
	}

	// Not Enable
	public static void notEnable(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.isEnabled(), false);
        System.out.println("element " + params.get("ID") + " is not enabled.");
	}

	// Visible
	public static void isVisible(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.isDisplayed(), true);
        System.out.println("element " + params.get("ID") + " is visible.");
	}

	// Not Visible
	public static void notVisible(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.isDisplayed(), false);
        System.out.println("element " + params.get("ID") + " is not visible.");
	}
}
