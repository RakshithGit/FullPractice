package genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	
	/**
	 * This class consists of Generic Methods related to Property File.
	 * @param propertyFileKey
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String propertyFileKey) throws Throwable {
		FileInputStream fsp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fsp);
		String value = p.getProperty(propertyFileKey);
		return value;
		
	}
	
}
