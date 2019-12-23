package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyManager.class);
	protected static final Properties prop = new Properties();
	public static final String APPLICATIONPROPERTIESPATH = "/src/test/resources/propertyFiles/";

	public static Properties loadApplicationProperty() {
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
					+ APPLICATIONPROPERTIESPATH + "application.properties");
			prop.load(fis);
		} catch (IOException io) {
			LOGGER.error(io.toString());

		} catch (Exception e) {
			LOGGER.error(e.toString());
		}

		return prop;
	}
	
}