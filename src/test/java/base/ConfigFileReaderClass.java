package base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReaderClass {
	BufferedReader reader;
	Properties properties;
	String PropertyFilepath = "./src/test/java/utility/config.properties";
	
	public ConfigFileReaderClass() {
		try {
			reader = new BufferedReader(new FileReader(PropertyFilepath));
			properties = new Properties();
	
			try {
				properties.load(reader);
				reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}catch(FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("Config.properties file not found at" +PropertyFilepath);
			}
			
			
	}
	
	public String getUrl() {
		String Url = properties.getProperty("AppUrl");
		if(Url != null) return Url;
		else throw new RuntimeException("Url not found in config.properties file");	
	}
	
	public String getBrowser() {
		String Browser = properties.getProperty("Browser");
		if(Browser != null) return Browser;
		else throw new RuntimeException("Browser not found in config.properties file");	
	}
	
	public String getBrowseDriver() {
		String BrowserDriver = properties.getProperty("ChromeDriverPath");
		if(BrowserDriver != null) return BrowserDriver;
		else throw new RuntimeException("Browser Driver not found in config.properties file");	
	}
	
	public String getExcelPath() {
		String Excelpath = properties.getProperty("DataExcelPath");
		if(Excelpath != null) return Excelpath;
		else throw new RuntimeException("Excelpath not found in config.properties file");	
	}
	
}
