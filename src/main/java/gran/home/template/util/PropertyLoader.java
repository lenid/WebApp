package gran.home.template.util;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
	private static final String CONFIG_FILE = "config.properties";
	private static final Properties PROPERTIES;

	static {
		PROPERTIES = new Properties();
		try {
			PROPERTIES.load(PropertyLoader.class.getClassLoader().getResourceAsStream(CONFIG_FILE));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	public static String getDbName() {
		return PROPERTIES.getProperty("database.name");
	}
	
	public static int getPort() {
		return new Integer(PROPERTIES.getProperty("application.port"));
	}

	public static String getHost() {
		return PROPERTIES.getProperty("application.host");
	}

	public static String getTimeFormat() {
		return PROPERTIES.getProperty("timeFormat");
	}

}
