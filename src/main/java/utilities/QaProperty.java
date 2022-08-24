package utilities;

public class QaProperty {
	
	/**
	 * get parameter from jvm or property file
	 * 
	 * @param key
	 * @return the property key value, or null if not exists
	 */
	public static final String getProperty(String key) {
		// try to load from jvm parameters first, if null, try to load from environment properties
		return System.getProperty(key, null);
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
	 * get boolean property
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
