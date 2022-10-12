package com.durgasoft.ecommerce.basepage;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BasePage {	
public static WebDriver driver;
public static final String path="./config.properties";
public String log4jpath="log4j.properties";
public static ExtentReports extent;
public ExtentTest test;
public ITestResult result;


static {
	Calendar cal=Calendar.getInstance();
	SimpleDateFormat dateFormat=new SimpleDateFormat("dd_MM_yyy_hh_mm_ss_");
	extent=new ExtentReports(System.getProperty("user.dir")+"/src/main/java/com/durgasoft"+
			"/ecommerce/htmlreports/test/"+dateFormat.format(cal.getTime())+".html",false);	
}



public String getData(String key) throws Exception {
	File f=new File(path);
	Properties p=new Properties();
	FileInputStream fi=new FileInputStream(f);
    p.load(fi);
    return p.getProperty(key);
   }

public void browserLaunch(String browser,String url) throws Exception {
	if(browser.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\lENOVO\\eclipse-workspace"
		  		+ "\\ecommerce\\chrome driver\\chromedriver.exe");
			driver=new ChromeDriver();
		//	C:\Users\lENOVO\eclipse-workspace\ecommerce\chrome driver
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\lENOVO\\Desktop\\Selenium"
					+ "\\chrome driver\\chromedriver.exe");
			driver=new FirefoxDriver();
	}
	else if(browser.equalsIgnoreCase("ie")) {
		  System.setProperty("webdriver.ie.driver", "C:\\Users\\lENOVO\\Desktop\\Selenium"
					+ "\\chrome driver\\chromedriver.exe");
			driver=new InternetExplorerDriver();
	}
	driver.get(url);
	driver.manage().window().maximize();
	PropertyConfigurator.configure(log4jpath);
  }
public int randomNumber() {
	 Random r=new Random();
	 int random=r.nextInt(9999);
	 return random;
  }
}
