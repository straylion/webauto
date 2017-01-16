package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Operation {

	// To click on the 'Cancel' button of the alert.
	public void cancelAlert(HashMap<String, String> params) {
		Browser.Driver.switchTo().alert().dismiss();
		sleep();
	}

	// To click on the 'OK' button of the alert.
	public void acceptAlert(HashMap<String, String> params) {
		Browser.Driver.switchTo().alert().accept();
		sleep();
	}

	// To capture the alert message.
	public void getTextFromAlert(HashMap<String, String> params) {
		Browser.Driver.switchTo().alert().getText();
	}

	// To send some data to alert box.
	public void sendKeysToAlert(HashMap<String, String> params) {
		Browser.Driver.switchTo().alert().sendKeys(params.get("Text"));
	}

	/**
	 * click element
	 * 
	 * @param params
	 */
	public void clickElement(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		waitForElement(params);
		element.click();
		System.out.println("Click element " + params.get("ID"));
	}

	/**
	 * clear element.
	 * 
	 * @param params
	 */
	public void clearElement(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		element.clear();
		System.out.println("Clear element " + params.get("ID"));
	}

	/**
	 * close all browsers.
	 * 
	 * @param parmas
	 */
	public void closeAllBrowser(Object parmas) {
		if (Browser.Driver != null)
			try {
				Browser.Driver.quit();
			} catch (Exception anException) {
				System.out.println("Closed All Browser and Killed task");
			}
	}

	/**
	 * close current window.
	 * 
	 * @param parmas
	 */
	public void closeCurrentWindow(Object parmas) {
		if (Browser.Driver != null)
			Browser.Driver.close();
	}

	/**
	 * delete cookie
	 * 
	 * @param params
	 */
	public void deleteCookie(HashMap<String, String> params) {
		if (params.get("Cookie Name").equals("ALL")) {
			System.out.println("Cookie Name == ALL");
			System.out.println("Before Cookies:" + Browser.Driver.manage().getCookies());
			Browser.Driver.manage().deleteAllCookies();
			System.out.println("After Cookies:" + Browser.Driver.manage().getCookies());
		} else {
			System.out.println("Other Cookie Name == " + params.get("Cookie Name"));
			System.out.println("Before Cookies:" + Browser.Driver.manage().getCookies());
			Browser.Driver.manage().deleteCookieNamed(params.get("Cookie Name"));
			System.out.println("After Cookies:" + Browser.Driver.manage().getCookies());
		}
	}

	/**
	 * double click
	 * 
	 * @param params
	 */
	public void doubleClick(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Actions action = new Actions(Browser.Driver);
		action.doubleClick(element);
		action.perform();
	}

	/**
	 * drag and drop
	 * 
	 * @param params
	 */
	public void dragAndDrop(HashMap<String, String> params) {
		HashMap<String, String> paramsFrom = new HashMap<String, String>();
		paramsFrom.put("ID", params.get("From ID"));
		WebElement element = Elements.find(paramsFrom, Browser.Driver);
		HashMap<String, String> paramsTo = new HashMap<String, String>();
		paramsTo.put("ID", params.get("To ID"));
		WebElement target = Elements.find(paramsTo, Browser.Driver);
		Actions action = new Actions(Browser.Driver);
		action.dragAndDrop(element, target);
		action.build();
		action.perform();
	}

	/**
	 * execute JavaScript
	 * 
	 * @param params
	 */
	public void executeJS(HashMap<String, String> params) {
		JavascriptExecutor js = (JavascriptExecutor) Browser.Driver;
		js.executeScript(params.get("Code"));
	}

	/**
	 * 
	 * @param params
	 */
	public void goBack(HashMap<String, String> params) {
		Browser.Driver.navigate().back();
	}

	/**
	 * 
	 * @param params
	 */
	public void goForward(HashMap<String, String> params) {
		Browser.Driver.navigate().forward();
	}

	/**
	 * 
	 * @param params
	 */
	public void Refresh(HashMap<String, String> params) {
		Browser.Driver.navigate().refresh();
	}

	/**
	 * mouse over on element
	 * 
	 * @param params
	 */
	public void mouseOver(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Actions action = new Actions(Browser.Driver);
		action.moveToElement(element).click().perform();
	}

	/**
	 * 
	 * @param params
	 */
	public void navigateToUrl(HashMap<String, String> params) {
		if (params.get("URL") != null) {
			if ((params.get("URL")).startsWith("http://") || (params.get("URL")).startsWith("https://")) {
				System.out.println("Navigate to: " + params.get("URL"));
				Browser.Driver.navigate().to(params.get("URL"));
			} else {
				System.out.println("Navigate to: " + params.get("URL"));
				Browser.Driver.navigate().to("http://" + params.get("URL"));
			}
		}
	}

	/**
	 * 
	 * @param params
	 */
	public void rightClick(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Actions action = new Actions(Browser.Driver);
		action.contextClick(element).perform();
	}

	/**
	 * drop down list
	 * 
	 * @param params
	 */
	public void selectItem(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		if (params.get("Visible Text") != null) {
			new Select(element).selectByVisibleText(params.get("Visible Text"));
		} else if (params.get("Value") != null) {
			new Select(element).selectByValue(params.get("Value"));
		} else if (params.get("Index") != null) {
			new Select(element).selectByIndex(Integer.parseInt(params.get("Index")));
		}
	}

	/**
	 * input text from excel
	 * 
	 * @param params
	 */
	public void sendKeys(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		switch (params.get("Text Type")) {
		case "User":
			try {
				InputStream is1 = new FileInputStream("User.xls");
				Map<String, String> map = this.readExcelContent(is1);
				element.sendKeys(map.get(params.get("Text")));
			} catch (FileNotFoundException e) {
				System.out.println("Excel file doesn't exist!");
				e.printStackTrace();
			}
			break;
		case "Product":
			try {
				InputStream is2 = new FileInputStream("Product.xls");
				Map<String, String> map = this.readExcelContent(is2);
				element.sendKeys(map.get(params.get("Text")));
			} catch (FileNotFoundException e) {
				System.out.println("Excel file doesn't exist!");
				e.printStackTrace();
			}
			break;
		case "Text":
			element.sendKeys(params.get("Text"));
			break;
		default:
			element.sendKeys(params.get("Text"));
		}
		System.out.println("Input to element " + params.get("ID"));
	}

	/**
	 * send current time to element
	 * 
	 * @param pElementXPath
	 * @return
	 */
	public void sendCurrentTimeToElement(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("MMddhhmmss");
		String time = format.format(date);
		System.out.println("Input to element " + params.get("ID") + " " + time);
		element.sendKeys(time);
	}

	/**
	 * 
	 * @param params
	 */
	public void sendTimetoElement(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		Date date0 = new Date();
		Date date1 = new Date(date0.getTime() + 3600000);
		DateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		String time0 = format.format(date0);
		String time1 = format.format(date1);
		if (params.get("Type").equals("Start")) {
			element.sendKeys(time0);
		} else {
			element.sendKeys(time1);
		}
	}

	public void newDate() {

	}

	/**
	 * focus on element
	 * 
	 * @param params
	 */
	public void setFocus(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		if (element.getTagName() == "input") {
			element.sendKeys("");
		} else {
			new Actions(Browser.Driver).moveToElement(element).perform();
		}
	}

	/**
	 * submit form
	 * 
	 * @param params
	 */
	public void submit(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		element.submit();
	}

	/**
	 * switch to new window
	 * 
	 * @param params
	 */
	public void switchToNewWindow(HashMap<String, String> params) {
		sleep();
		Set<String> winHandels = Browser.Driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		Browser.Driver.switchTo().window(it.get(1));
	}

	/**
	 * switch to window using window name
	 * 
	 * @param params
	 */
	public void switchToWindow(HashMap<String, String> params) {
		int iTimeout = 20;
		if (params.get("Window Name") == "Default Window") {
			Browser.Driver.switchTo().window(Browser.MainWinHandle);
			return;
		}
		while (iTimeout > 0) {
			for (String handle : Browser.Driver.getWindowHandles()) {
				Browser.Driver.switchTo().window(handle);
				if (Browser.Driver.getTitle().equals(params.get("Window Name"))) {
					return;
				}
			}
			iTimeout--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Window:" + params.get("Window Name") + "does not exist.");
		}
	}

	/**
	 * switch to frame
	 * 
	 * @param params
	 */
	public void switchToFrame(HashMap<String, String> params) {
		Browser.Driver.switchTo().frame(params.get("ID or Name"));
	}

	/**
	 * 
	 * @param params
	 */
	public void switchToDefaultContent(HashMap<String, String> params) {
		Browser.Driver.switchTo().defaultContent();
	}

	/* !----GET----! */

	/**
	 * get element attribute value
	 * 
	 * @param params
	 * @return
	 */
	public String getAttributeValue(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		return element.getAttribute(params.get("Attribute Name"));
	}

	public String getCookieValue(HashMap<String, String> params) {
		if (params.get("Cookie Name").equals("ALL")) { // all cookies
			String cookie = Browser.Driver.manage().getCookies().toString();
			System.out.println("All cookies: " + cookie);
			return cookie;
		} else { // single cookie
			Cookie cookie = Browser.Driver.manage().getCookieNamed(params.get("Cookie Name"));
			assert cookie != null : "Error: cookie not found";
			System.out.println("Cookie " + params.get("Cookie Name") + " value: " + cookie.getValue());
			return cookie.getValue();
		}
	}

	/**
	 * get element css value
	 * 
	 * @param params
	 * @return
	 */
	public String getCssValue(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		String value = element.getCssValue(params.get("Css Key"));
		System.out.println("Element " + params.get("ID") + " Css " + params.get("Css Key") + ": " + value);
		return value;
	}

	/**
	 * 
	 * @param params
	 * @return
	 */
	public String getUrl(HashMap<String, String> params) {
		String url = Browser.Driver.getCurrentUrl();
		System.out.println("Current Url is: " + url);
		return url;
	}

	/**
	 * get element location
	 * 
	 * @param params
	 * @return
	 */
	public Point getElementLocation(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		return element.getLocation();
	}

	/**
	 * ()
	 * 
	 * @param params
	 * @return
	 */
	public Dimension getElementSize(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		return element.getSize();
	}

	/**
	 * 
	 * @param params
	 * @return
	 */
	public int getElementHeight(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		return element.getSize().getHeight();
	}

	/**
	 * 
	 * @param params
	 * @return
	 */
	public int getElementWidth(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		return element.getSize().getWidth();
	}

	/**
	 * 
	 * @param params
	 * @return
	 */
	public String getPageSource(HashMap<String, String> params) {
		String ps = Browser.Driver.getPageSource();
		System.out.println("Page Source is: " + ps);
		return ps;
	}

	/**
	 * 
	 * @param params
	 * @return
	 */
	public String getPageTitle(HashMap<String, String> params) {
		String pt = Browser.Driver.getTitle();
		System.out.println("Page Title is: " + pt);
		return pt;
	}

	/**
	 * 
	 * @param params
	 * @return
	 */
	public String getTagName(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		String tn = element.getTagName();
		System.out.println("Element " + params.get("ID") + " tag name: " + tn);
		return tn;
	}

	/**
	 * 
	 * @param params
	 * @return
	 */
	public String getText(HashMap<String, String> params) {
		WebElement element = Elements.find(params, Browser.Driver);
		String text = element.getText();
		System.out.println("Element " + params.get("ID") + " text: " + text);
		return text;
	}

	/**
	 * get coupon id using regex
	 * 
	 * @param params
	 * @return
	 */
	public String getCouponID(HashMap<String, String> params) {
		List<WebElement> elements = Elements.findAll(params, Browser.Driver);
		String text = elements.get(0).getText();
		return text.split("\\D+")[2];
	}

	/**
	 * 
	 * @param params
	 * @return
	 */
	public String getWindowHandle(HashMap<String, String> params) {
		String wh = Browser.Driver.getWindowHandle();
		System.out.println("Window handle: " + wh);
		return wh;
	}

	/* !----WAIT----! */

	/**
	 * wait x seconds
	 * 
	 * @param params
	 */
	public void wait(HashMap<String, String> params) {
		if (params.get("Seconds") != null) {
			try {
				Thread.sleep(Integer.parseInt(params.get("Seconds")) * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * wait for element until timeout
	 * 
	 * @param params
	 */
	public void waitForElement(HashMap<String, String> params) {
		int count = 10;
		while (count >= 0) {
			WebElement element = Elements.find(params, Browser.Driver);
			if (element != null && element.isDisplayed())
				break;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count--;
		}
		if (count <= 0) {
			System.out.println("Element was not found in 10 seconds.");
		}
	}

	/**
	 * 
	 * sleep the fixed time.
	 * 
	 */
	public void sleep() {
		try {
			Thread.sleep(2 * 1000);
		} catch (final InterruptedException e) {
			System.out.println("sleep " + e);
		}
	}

	/**
	 * read Excel
	 * 
	 * @param InputStream
	 * @return Map
	 */
	public Map<String, String> readExcelContent(InputStream is) {
		POIFSFileSystem fs;
		HSSFWorkbook wb = null;
		HSSFSheet sheet;
		HSSFRow row;
		Map<String, String> content = new HashMap<String, String>();
		String str = "";
		try {
			fs = new POIFSFileSystem(is);
			wb = new HSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		for (int i = 0; i <= rowNum; i++) {
			row = sheet.getRow(i);
			int j = 0;
			while (j < colNum) {
				str = getCellFormatValue(row.getCell(j));
				content.put(row.getCell(0) + "." + sheet.getRow(0).getCell(j), str);
				j++;
			}
		}
		return content;
	}

	/**
	 * 
	 * @param cell
	 * @return
	 */
	private String getCellFormatValue(HSSFCell cell) {
		String cellvalue = "";
		if (cell != null) {
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_NUMERIC:
			case HSSFCell.CELL_TYPE_FORMULA: {
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					cellvalue = sdf.format(date);
				} else {
					// change numeric to string
					DecimalFormat df = new DecimalFormat("0");
					cellvalue = df.format(cell.getNumericCellValue());
				}
				break;
			}
			case HSSFCell.CELL_TYPE_STRING:
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			default:
				cellvalue = "";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;
	}

}
