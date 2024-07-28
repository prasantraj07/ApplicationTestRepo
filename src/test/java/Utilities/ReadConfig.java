package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
	
	Properties properties;
	String path = "Config.properties";
	
	
	public ReadConfig() throws IOException 
	{
		properties = new Properties();
		
		//to open Config.properties file in Input mode & load the file:
		FileInputStream f1 = new FileInputStream(path);
		properties.load(f1);
		
	}
	
	
	
	public String getBrowser() 
	{
		String value = properties.getProperty("browser");
		
		if(value!=null)
			return value;
		else
			throw new RuntimeException("Browser not specified in config.file");
		
	}

}






