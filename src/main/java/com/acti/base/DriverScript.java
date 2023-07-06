package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverScript {
	public static WebDriver driver;
	Properties prop = new Properties();

	public DriverScript() {
		try {
			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("unable to load properties file" + e.getMessage());
			e.printStackTrace();

		}
	}

	
	public void initializeApp() {
		String browservalue = prop.getProperty("browser");
		if (browservalue.equalsIgnoreCase("chrome")) {
			System.out.println("browser in use : " + browservalue);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browservalue.equalsIgnoreCase("edge")) {
			System.out.println("browser in use : " + browservalue);
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browservalue.equalsIgnoreCase("firefox")) {
			System.out.println("browser in use : " + browservalue);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else {
			System.out.println(browservalue + ": is not a supported browser.Check config file");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		launchApplication();
	
	
	}

	public void launchApplication() {
		String url = prop.getProperty("url");
		driver.get(url);

	}
	public void quitDriver() {
		driver.close();
	}

}
