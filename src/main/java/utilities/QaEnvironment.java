package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class QaEnvironment {
	private static String filename = System.getProperty("user.dir") + "\\environment.properties";
	private static Properties props = new Properties();

	static {
		try {
			FileInputStream inputStream = new FileInputStream(filename);
			props.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * get parameter from jvm or property file
	 * 
	 * @param key
	 * @return the property key value, or null if not exists
	 */
	public static final String getProperty(String key) {
		// try to load from jvm parameters first, if null, try to load from environment
		String val = System.getProperty(key, null);
		if (val == null) {
			val = props.getProperty(key);
		}
		return val;
	}

	/**
	 * get parameter from jvm or property file
	 * 
	 * @param key
	 * @param default
	 * @return the property key value, or <defaultValue> if not exists
	 */
	public static final String getProperty(String key, String defaultValue) {
		String val = getProperty(key);
		return (val == null) ? defaultValue : val;
	}

	/**
	 * get boolean propery
	 * 
	 * @param propKey
	 * @param defaultValue
	 * @return
	 */
	public static boolean getBoolean(String propKey, boolean defaultValue) {
		return Boolean.parseBoolean(getProperty(propKey, String.valueOf(defaultValue)));
	}

	/**
	 * get integer property
	 * 
	 * @param propKey
	 * @param defaultValue
	 * @return
	 */
	public static int getInteger(String propKey, int defaultValue) {
		return Integer.parseInt(getProperty(propKey, String.valueOf(defaultValue)));
	}

}
