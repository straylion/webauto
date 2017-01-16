package common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

	/**
	 * 
	 * @param params
	 * @param Driver
	 * @return
	 */
	public static WebElement find(HashMap<String, String> params, WebDriver Driver) {
		WebElement foundElement = Driver.findElement(By.xpath(Elements.getP(params.get("ID"))));
		return foundElement;
	}

	/**
	 * 
	 * @param params
	 * @param Driver
	 * @return
	 */
	public static List<WebElement> findAll(HashMap<String, String> params, WebDriver Driver) {
		List<WebElement> foundElements = Driver.findElements(By.xpath(Elements.getP(params.get("ID"))));
		return foundElements;
	}

	/**
	 * Read properties
	 * 
	 * @param filePath
	 * @return
	 */
	public static Properties readProperties(File filePath) {
		Properties p = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(filePath));
			p.load(in);

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
	public static String getP(String param) {
//		String filePath = "./resources/elementpath.properties";
		File filePath = new File("elementpath.properties");
		Properties p = readProperties(filePath);
		String pr = p.getProperty(param);
		return pr;
	}

}