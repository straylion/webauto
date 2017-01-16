package common;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

/**
 * 
 * @author stray
 *
 */
public class Browser {

	public static WebDriver Driver = null;
	public static String MainWinHandle = null;

	/**
	 * open browser and get url
	 * 
	 * @param params
	 */
	public void openBrowser(HashMap<String, String> params) {
		switch (params.get("Browser Type")) {
		case "Firefox":
			Driver = new FirefoxDriver();
			break;
		case "Chrome":
			ChromeDriverService service = new ChromeDriverService.Builder().usingPort(9518)
					.usingDriverExecutable(new File("chromedriver.exe")).build();
			try {
				service.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
			break;
		default:
			InternetExplorerDriverService serviceIE = new InternetExplorerDriverService.Builder().usingPort(9516)
					.usingDriverExecutable(new File("MicrosoftWebDriver.exe")).build();
			try {
				serviceIE.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DesiredCapabilities d = DesiredCapabilities.internetExplorer();
			d.setCapability("nativeEvents", false);
			d.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			Driver = new RemoteWebDriver(serviceIE.getUrl(), d);
		}
		Driver.manage().window().maximize();
		if (params.get("URL") != null) {
			if ((params.get("URL")).startsWith("http://") || (params.get("URL")).startsWith("https://")) {
				Driver.get(params.get("URL"));
			} else {
				Driver.get("http://" + params.get("URL"));
			}
		}
		System.out.println("Open " + params.get("Browser Type") + " and navigate to " + params.get("URL"));
		Driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
		MainWinHandle = Driver.getWindowHandle();
	}
}
