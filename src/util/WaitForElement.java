package util;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import common.Elements;
import util.Browser;

public class WaitForElement {

	public void run(HashMap<String, String> params) {
		int count = Integer.parseInt(params.get("Timeout In Seconds"));

		while (count >= 0) {
			WebElement element = Elements.find(params, Browser.Driver);
			if (element != null)
				break;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count--;
		}
		if (count <= 0) {
			System.out.println("Element was not found in" + params.get("Timeout In Seconds") + "seconds.");
		}

	}
}
