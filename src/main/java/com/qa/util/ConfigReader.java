package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public Properties init_prop() {

		prop = new Properties();
		try {
			// no need to give full path , give . and then path from src
			FileInputStream fis = new FileInputStream("/Users/angshumanbanerjee/Desktop/CucumberPOMFramework/src/test/resources/config/config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
		return prop;
	}
}
