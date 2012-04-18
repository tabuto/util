package com.tabuto.commons.util;

import java.util.Properties;

public class JavaUtil {
	
	/**
	 * Return true is the current JVM version executes this code is equals or higher than version parameter
	 * @param version <code>double</code> 
	 * @return <code>boolean</code>
	 */
	public static boolean isVersionHigherThan(double version)
	{
		float v =(float) version;
		boolean result = false;
		String sVersion ="";
		Properties sProp = java.lang.System.getProperties();
		sVersion = sProp.getProperty("java.version");
		sVersion = sVersion.substring(0,3);
		Float f = Float.valueOf(sVersion);
			if (f.floatValue() >= (float) v)
				return result = true;
		
			return result;
	}

	/**
	 * Return true is the current JVM version executes this code is equals or lower than version parameter
	 * @param version <code>double</code> 
	 * @return <code>boolean</code>
	 */
	public static boolean isVersionLowerThan(double version)
	{
		float v =(float) version;
		boolean result = false;
		String sVersion ="";
		Properties sProp = java.lang.System.getProperties();
		sVersion = sProp.getProperty("java.version");
		sVersion = sVersion.substring(0,3);
		Float f = Float.valueOf(sVersion);
			if (f.floatValue() <= (float) v)
				return result = true;
		
			return result;
	}

}
