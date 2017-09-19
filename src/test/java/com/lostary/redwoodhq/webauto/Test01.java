package com.lostary.redwoodhq.webauto;

import java.util.HashMap;

public class Test01 {
	
	public static void main(String[] args) {
		
		HashMap<String, String> param0 = new HashMap<String, String>();
		HashMap<String, String> param1 = new HashMap<String, String>();
		HashMap<String, String> param2 = new HashMap<String, String>();
		HashMap<String, String> param3 = new HashMap<String, String>();
		HashMap<String, String> param4 = new HashMap<String, String>();
		HashMap<String, String> param5 = new HashMap<String, String>();
		HashMap<String, String> param6 = new HashMap<String, String>();
		HashMap<String, String> param7 = new HashMap<String, String>();
		param0.put("URL", "www.baidu.com");
		param0.put("Browser Type", "Chrome");
		
		param1.put("ID", "searchbtn");
		
		Browser br = new Browser(param0);
		Operation op = new Operation();
		op.clickElement(param1);
	}
}
