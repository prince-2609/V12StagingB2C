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
	
	/**
     * Get property as double
     * 
     * @param propKey
     * @param defaultValue
     * @return double value
     */
    public static double getDouble(String propKey, double defaultValue) {
        String value = getProperty(propKey);
        if (value == null) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            // Log the exception or handle it as needed
            System.err.println("Error parsing double value for property: " + propKey);
            return defaultValue;
        }
    }

    /**
     * Get property as long
     * 
     * @param propKey
     * @param defaultValue
     * @return long value
     */
    public static long getLong(String propKey, long defaultValue) {
        String value = getProperty(propKey);
        if (value == null) {
            return defaultValue;
        }
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            // Log the exception or handle it as needed
            System.err.println("Error parsing long value for property: " + propKey);
            return defaultValue;
        }
    }
    
}
