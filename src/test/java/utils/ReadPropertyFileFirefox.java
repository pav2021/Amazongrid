package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class ReadPropertyFileFirefox {

	Properties prop;
	public Properties readpropFile() {
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(".\\src\\test\\resources\\configproperties\\config2.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
