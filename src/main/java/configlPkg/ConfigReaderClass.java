package configlPkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderClass {

	String path= "src/test/resources/propertiesFiles/configuration.properties";

	Properties prop;


	public ConfigReaderClass() {

		prop = new Properties ();
		
		try {
		FileInputStream fis = new FileInputStream(path);
			  prop.load(fis);
		}	

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getConfigProperty(String key) {
		return	prop.getProperty(key);

	}


}




