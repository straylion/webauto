package util;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	public static WebDriver Driver = null;
	public static String MainWinHandle = null;

	// start browser
	public static void run(HashMap<String, String> params) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch (params.get("Browser Type")) {
		case "Firefox":
			Driver = new FirefoxDriver();
			break;
		case "Chrome":
            System.setProperty("webdriver.chrome.driver", "\\\\testmech\\WebAuto\\chromedriver.exe");
			Driver = new ChromeDriver();
            System.out.println(Driver);
			break;
		default:
            System.setProperty("webdriver.ie.driver","\\\\testmech\\WebAuto\\IEDriverServer.exe");
			Driver = new InternetExplorerDriver();
		}
		
		Driver.manage().window().maximize();
		
		if (params.get("URL") != null) {
			if ((params.get("URL")).startsWith("http://")
					|| (params.get("URL")).startsWith("https://")) {
				Driver.get(params.get("URL"));
			} else {
				Driver.get("http://" + params.get("URL"));
			}

		}
		
		Driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
		MainWinHandle = Driver.getWindowHandle();

	}
}