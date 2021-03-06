package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File f = new File(".//Configuration/config.properties");
		
		try {
			
			FileInputStream fis = new FileInputStream(f);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
				
			System.out.println("Exception is"+ e.getMessage());

		}
		
		
	}
	
	public String getUserID()
	{
		String userid = pro.getProperty("username");
		return userid;
	}
	
	public String getpassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("URL");
		return url;
	}
	
	public String getchromepath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getgeckodriverpath()
	{
		String geckodriverpath = pro.getProperty("geckodriverpath");
		return geckodriverpath;
	}
	
	public String getIEdriverpath()
	{
		String IEdriverpath = pro.getProperty("IEdriverpath");
		return IEdriverpath;
	}

}
