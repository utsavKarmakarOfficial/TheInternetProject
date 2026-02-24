package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import constants.FrameworkConstants;

public class ConfigReader {

	private static Properties prop = new Properties();

	static {
		loadProperties();
	}

	private static void loadProperties() {

		try {

			String env = System.getProperty("env", "qa");
			String path = FrameworkConstants.CONFIG_PATH + env + ".properties";

			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String key) {
		return prop.getProperty(key);
	}

}
