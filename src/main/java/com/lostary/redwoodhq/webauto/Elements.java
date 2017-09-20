package com.lostary.redwoodhq.webauto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

/**
 * Use XPath only
 * 
 * @author stray
 *
 */
public class Elements {
	
	WebDriver webDriver = Browser.Driver;

	/**
	 * 
	 * @param params
	 * @param Driver
	 * @return
	 */
	public WebElement find(HashMap<String, String> params) {
		WebElement foundElement = webDriver.findElement(By.xpath(this.getP(params.get("ID"))));
		return foundElement;
	}

	/**
	 * 
	 * @param params
	 * @param Driver
	 * @return
	 */
	public List<WebElement> findAll(HashMap<String, String> params) {
		List<WebElement> foundElements = webDriver.findElements(By.xpath(this.getP(params.get("ID"))));
		return foundElements;
	}

	/**
	 * Read properties
	 * 
	 * @param filePath
	 * @return
	 */
	private Properties readProperties(File filePath) {
		Properties p = new Properties();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
			p.load(br);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * read key-value (param-pr)
	 * 
	 * @param param
	 * @return
	 */
	private String getP(String param) {
		// String filePath = "./resources/elementpath.properties";
		File filePath = new File("elementpath.properties");
		Properties p = readProperties(filePath);
		String pr = p.getProperty(param);
		return pr;
	}

}