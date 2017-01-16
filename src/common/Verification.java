package common;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Verification {

	/* !----Assert.assertEquals(actual, expected);----! */

	/**
	 * 
	 * @param params
	 */
	public void attribute(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.getAttribute(params.get("Attribute Name")), params.get("Value"));
		System.out.println(
				"Element " + params.get("ID") + " \'s " + params.get("Attribute Name") + " is " + params.get("Value"));
	}

	/**
	 * 
	 * @param params
	 */
	public void attributeContain(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertTrue(element.getAttribute(params.get("Attribute Name")).contains(params.get("Value")));
		System.out.println("Element " + params.get("ID") + " \'s " + params.get("Attribute Name") + " contains "
				+ params.get("Value"));
	}

	/**
	 * 
	 * @param params
	 */
	public void pageTitle(HashMap<String, String> params) {
		Assert.assertEquals(Browser.Driver.getTitle(), params.get("Title"));
		System.out.println("Page Title is " + params.get("Title"));
	}

	/**
	 * 
	 * @param params
	 */
	public void pageTitleContain(HashMap<String, String> params) {
		Assert.assertTrue(Browser.Driver.getTitle().contains(params.get("Title")));
		System.out.println("Page Title contains " + params.get("Title"));
	}
	
	/**
	 * 
	 * @param params
	 */
	public void selectedItem(HashMap<String, String> params) {
		System.out.println("Except selectedItem is:" + params);
		WebElement element = Elements.find(params, Browser.Driver);
		WebElement option = new Select(element).getFirstSelectedOption();
		String selectedLabel = option.getText();
		String selectedValue = option.getAttribute("value");
		if (params.get("Item Label") != null) {
			Assert.assertEquals(selectedLabel, params.get("Item Label"));
		}
		if (params.get("Item Value") != null) {
			Assert.assertEquals(selectedValue, params.get("Item Value"));
		}
	}

	/**
	 * 
	 * @param params
	 */
	public void text(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.getText(), params.get("Text"));
		System.out.println("Element " + params.get("ID") + "\'s Text is" + params.get("Text"));
	}

	/**
	 * 
	 * @param params
	 */
	public void textContain(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertTrue(element.getText().contains(params.get("Text")));
		System.out.println("Element " + params.get("ID") + "\'s Text contains" + params.get("Text"));
	}

	/**
	 * 
	 * @param params
	 */
	public void currentUrl(HashMap<String, String> params) {
		Assert.assertEquals(Browser.Driver.getCurrentUrl(), params.get("Value"));
		System.out.println("Current URL is " + params.get("Value"));
	}

	/**
	 * 
	 * @param params
	 */
	public void currentUrlContain(HashMap<String, String> params) {
		Assert.assertTrue(Browser.Driver.getCurrentUrl().contains(params.get("Value")));
		System.out.println("Current URL contains " + params.get("Value"));
	}

	/**
	 * verify checkbox is selected or not
	 * 
	 * @param params
	 */
	public void checkbox(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.isSelected(), params.get("Is Selected").equals("true"));
		System.out.println("Checkbox " + params.get("ID") + " is Selected: " + params.get("Is Selected"));
	}

	/**
	 * verify element is existed
	 * 
	 * @param params
	 */
	public void isExisted(HashMap<String, String> params) {
		List<WebElement> elements = Elements.findAll(params, Browser.Driver);
		Assert.assertNotEquals(elements.size(), 0);
		System.out.println("Element " + params.get("ID") + " is existed.");
	}

	/**
	 * verify element is not existed
	 * 
	 * @param params
	 */
	public void notExisted(HashMap<String, String> params) {
		List<WebElement> elements = Elements.findAll(params, Browser.Driver);
		Assert.assertEquals(elements.size(), 0);
		System.out.println("Element " + params.get("ID") + " is not existed.");
	}

	/**
	 * 
	 * @param params
	 */
	public void exist(HashMap<String, String> params) {
		List<WebElement> elements = Elements.findAll(params, Browser.Driver);
		String str = params.get("Number of Matches");
		if (null == str || "".equals(str) || "null".equals(str)) {
			Assert.assertEquals(elements.size() > 0, true);
			System.out.println("Element " + params.get("ID") + " is existed.");
		} else {
			Assert.assertEquals(elements.size(), Integer.parseInt(params.get("Number of Matches")));
			System.out.println("Element " + params.get("ID") + " exist " + params.get("Number of Matches"));
		}
	}

	/**
	 * 
	 * @param params
	 */
	public void isEnable(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.isEnabled(), true);
		System.out.println("Element " + params.get("ID") + " is enabled.");
	}

	/**
	 * 
	 * @param params
	 */
	public void notEnable(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.isEnabled(), false);
		System.out.println("Element " + params.get("ID") + " is not enabled.");
	}

	/**
	 * 
	 * @param params
	 */
	public void isVisible(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.isDisplayed(), true);
		System.out.println("Element " + params.get("ID") + " is visible.");
	}

	/**
	 * 
	 * @param params
	 */
	public void notVisible(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Assert.assertEquals(element.isDisplayed(), false);
		System.out.println("Element " + params.get("ID") + " is not visible.");
	}

	/**
	 * verify actual contains expected
	 * 
	 * @param params
	 */
	public void contain(HashMap<String, String> params) {
		String actual = params.get("Actual");
		String expected = params.get("Expected");
		Assert.assertTrue(actual.contains(expected));
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
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
	}
}
