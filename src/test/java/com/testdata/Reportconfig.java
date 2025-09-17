package com.testdata;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Reportconfig {

	public static Properties pro;
	
	public void reportconfig() throws IOException {
		

		FileReader ippath= new FileReader("C:\\SeleniumEclipse\\Automation_Project\\configuration\\config.properties");
		pro = new Properties();
		pro.load(ippath);
		//pro.getProperty(geturl());

	}

	public String geturl(String baseurl) {
		String url=pro.getProperty(baseurl);
		return url;
	}



	public String getuname() {
		String uname= pro.getProperty("username");
		return uname;
	}

	public String getpwd() {
		String pwd= pro.getProperty("password");
		return pwd;
	}

	public  String chromepath(String chromepath) {
		String browser= pro.getProperty("chromepath");
		return browser;
	}


	public static String edgepath() {
		String browser= pro.getProperty("browser");
		return browser;
	}

	public static String geckopath() {
		String browser= pro.getProperty("browser");
		return browser;
	}

}
