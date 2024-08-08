package utils;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ConfigReader {
	
	public static Properties InitiliazeProperties() throws IOException {
		
		Properties prop = new Properties();
		
//		String proFile = System.getProperty("user.dir")+ "\\src\\test\\resources\\config\\config.properties";
//		
//		System.out.println(proFile);
//		
		// get the file name
		File proFile = new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\config\\config.properties");
		
		System.out.println(proFile + "Name of proFile path");
		
		
		try {
			
			// Read the file 
			FileInputStream fis = new FileInputStream(proFile);
			
			
			//process the file content using prop object which reads key and value pair
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
		
	}

}
