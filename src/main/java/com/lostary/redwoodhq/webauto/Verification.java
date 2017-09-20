package com.lostary.redwoodhq.webauto;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

@SuppressWarnings("unused")
public class Verification extends Elements {
	
	/* !----Assert.assertEquals(actual, expected);----! */

	/**
	 * 
	 * @param params
	 */
	public void attribute(HashMap<String, String> params) {
		WebElement element = super.find(params);
		String message = " ERROR: Element " + params.get("ID") + " \'s " + params.get("Attribute Name");
		Assert.assertEquals(element.getAttribute(params.get("Attribute Name")), params.get("Value"), message);
		System.out.println(
				"Element " + params.get("ID") + " \'s " + params.get("Attribute Name") + " is " + params.get("Value"));
	}

	/**
	 * 
	 * @param params
	 */
	public void attributeContain(HashMap<String, String> params) {
		WebElement element = super.find(params);
		String message = " ERROR: Element " + params.get("ID") + " \'s " + params.get("Attribute Name");
		Assert.assertTrue(element.getAttribute(params.get("Attribute Name")).contains(params.get("Value")), message);
		System.out.println("Element " + params.get("ID") + " \'s " + params.get("Attribute Name") + " contains "
				+ params.get("Value"));
	}

	/**
	 * 
	 * @param params
	 */
	public void pageTitle(HashMap<String, String> params) {
		Assert.assertEquals(webDriver.getTitle(), params.get("Title"), "ERROR: Page Title: ");
		System.out.println("Page Title is " + params.get("Title"));
	}

	/**
	 * 
	 * @param params
	 */
	public void pageTitleContain(HashMap<String, String> params) {
		Assert.assertTrue(webDriver.getTitle().contains(params.get("Title")), "ERROR: Page Title: ");
		System.out.println("Page Title contains " + params.get("Title"));
	}

	/**
	 * 
	 * @param params
	 */
	public void selectedItem(HashMap<String, String> params) {
		System.out.println("Except selectedItem is:" + params);
		WebElement element = super.find(params);
		WebElement option = new Select(element).getFirstSelectedOption();
		String selectedLabel = option.getText();
		String selectedValue = option.getAttribute("value");
		if (params.get("Item Label") != null) {
			Assert.assertEquals(selectedLabel, params.get("Item Label"), "ERROR: Selected Label: ");
		}
		if (params.get("Item Value") != null) {
			Assert.assertEquals(selectedValue, params.get("Item Value"), "ERROR: Selected Label: ");
		}
	}

	/**
	 * 
	 * @param params
	 */
	public void text(HashMap<String, String> params) {
		WebElement element = super.find(params);
		Assert.assertEquals(element.getText(), params.get("Text"), "ERROR: Element Text: ");
		System.out.println("Element " + params.get("ID") + "\'s Text is" + params.get("Text"));
	}

	/**
	 * 
	 * @param params
	 */
	public void textContain(HashMap<String, String> params) {
		WebElement element = super.find(params);
		Assert.assertTrue(element.getText().contains(params.get("Text")), "ERROR: Element Text: ");
		System.out.println("Element " + params.get("ID") + "\'s Text contains" + params.get("Text"));
	}

	/**
	 * 
	 * @param params
	 */
	public void currentUrl(HashMap<String, String> params) {
		Assert.assertEquals(webDriver.getCurrentUrl(), params.get("Value"), "ERROR: Current URL: ");
		System.out.println("Current URL is " + params.get("Value"));
	}

	/**
	 * 
	 * @param params
	 */
	public void currentUrlContain(HashMap<String, String> params) {
		Assert.assertTrue(webDriver.getCurrentUrl().contains(params.get("Value")), "ERROR: Current URL: ");
		System.out.println("Current URL contains " + params.get("Value"));
	}

	/**
	 * verify checkbox is selected or not
	 * 
	 * @param params
	 */
	public void checkbox(HashMap<String, String> params) {
		WebElement element = super.find(params);
		Assert.assertEquals(element.isSelected(), params.get("Is Selected").equals("true"), "ERROR: Checkbox: ");
		System.out.println("Checkbox " + params.get("ID") + " is Selected: " + params.get("Is Selected"));
	}

	/**
	 * verify element is existed
	 * 
	 * @param params
	 */
	public void isExisted(HashMap<String, String> params) {
		List<WebElement> elements = super.findAll(params);
		String message = "Element " + params.get("ID") + " is NOT existed.";
		Assert.assertNotEquals(elements.size(), 0, message);
		System.out.println("Element " + params.get("ID") + " is existed.");
	}

	/**
	 * verify element is not existed
	 * 
	 * @param params
	 */
	public void notExisted(HashMap<String, String> params) {
		List<WebElement> elements = super.findAll(params);
		String message = "Element " + params.get("ID") + " is Existed.";
		Assert.assertEquals(elements.size(), 0, message);
		System.out.println("Element " + params.get("ID") + " is not existed.");
	}

	/**
	 * 
	 * @param params
	 */
	public void exist(HashMap<String, String> params) {
		List<WebElement> elements = super.findAll(params);
		String str = params.get("Number of Matches");
		if (null == str || "".equals(str) || "null".equals(str)) {
			String message = "Element " + params.get("ID") + " is NOT existed.";
			Assert.assertEquals(elements.size() > 0, true, message);
			System.out.println("Element " + params.get("ID") + " is existed.");
		} else {
			String message = "ERROR: Element " + params.get("ID") + " Exist X times.";
			Assert.assertEquals(elements.size(), Integer.parseInt(params.get("Number of Matches")), message);
			System.out.println("Element " + params.get("ID") + " exist " + params.get("Number of Matches"));
		}
	}

	/**
	 * 
	 * @param params
	 */
	public void isEnable(HashMap<String, String> params) {
		WebElement element = super.find(params);
		Assert.assertEquals(element.isEnabled(), true, "ERROR: Disabled.");
		System.out.println("Element " + params.get("ID") + " is enabled.");
	}

	/**
	 * 
	 * @param params
	 */
	public void notEnable(HashMap<String, String> params) {
		WebElement element = super.find(params);
		Assert.assertEquals(element.isEnabled(), false, "ERROR: Enabled");
		System.out.println("Element " + params.get("ID") + " is disabled.");
	}

	/**
	 * 
	 * @param params
	 */
	public void isVisible(HashMap<String, String> params) {
		WebElement element = super.find(params);
		Assert.assertEquals(element.isDisplayed(), true, "ERROR: NOT visible.");
		System.out.println("Element " + params.get("ID") + " is visible.");
	}

	/**
	 * 
	 * @param params
	 */
	public void notVisible(HashMap<String, String> params) {
		WebElement element = super.find(params);
		Assert.assertEquals(element.isDisplayed(), false, "ERROR: Visible.");
		System.out.println("Element " + params.get("ID") + " is not visible.");
	}

	/**
	 * verify input box is editable
	 * 
	 * @param params
	 */
	public void isEditable(HashMap<String, String> params) {
		WebElement element = super.find(params);
		Assert.assertEquals(true, element.getAttribute("readonly") == null || element.getAttribute("disabled") == null,
				"ERROR: NOT Editable!");
		System.out.println("Element " + params.get("ID") + " is editable.");
	}

	/**
	 * verify actual contains expected
	 * 
	 * @param params
	 */
	public void contain(HashMap<String, String> params) {
		String actual = params.get("Actual");
		String expected = params.get("Expected");
		Assert.assertTrue(actual.contains(expected), "ERROR: NOT contain.");
		System.out.println(actual + " contains " + expected);
	}

	/**
	 * verify actual equals expected
	 * 
	 * @param params
	 */
	public void equal(HashMap<String, String> params) {
		String actual = params.get("Actual");
		String expected = params.get("Expected");
		Assert.assertEquals(actual, expected, "NOT equil.");
		System.out.println(actual);
	}
}
