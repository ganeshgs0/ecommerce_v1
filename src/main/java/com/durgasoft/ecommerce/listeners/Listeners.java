package com.durgasoft.ecommerce.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.durgasoft.ecommerce.basepage.BasePage;

public class Listeners extends BasePage implements ITestListener {

	public void onTestStart(ITestResult arg0) {
		Reporter.log("test is started "+arg0.getMethod().getMethodName());
	}
	
	public void onTestSkipped(ITestResult arg0) {
		Reporter.log("test is skipped "+arg0.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult arg0) {
		Reporter.log("test is passed "+arg0.getMethod().getMethodName());
	
		Calendar cal=Calendar.getInstance();
SimpleDateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss_");
String methodName=arg0.getName();
if(arg0.isSuccess()) {
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	String reportDirectory=(new File(System.getProperty("user.dir")).getAbsolutePath()
			+"/src/main/java/com/durgasoft/ecommerce");
File trg=new File((String)reportDirectory+"/passedscreens/" +methodName+"_"+
dateFormat.format(cal.getTime())+".png");
try {
	FileUtils.copyFile(src, trg);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
	}
	
	public void onTestFailure(ITestResult arg0) {
		Reporter.log("test is failed "+arg0.getMethod().getMethodName());
		Calendar cal=Calendar.getInstance();
SimpleDateFormat dateFormat=new SimpleDateFormat("dd_MM_yyy_hh_mm_ss_");
String methodName=arg0.getName();
if(!arg0.isSuccess()) {
	String reportDirectory=System.getProperty("user.dir")
			+"/src/main/java/com/durgasoft/ecommerce/failedscreens/" +methodName+"_"
			+ dateFormat.format(cal.getTime())+".png";
	
File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
File trg=new File(reportDirectory);
try {
	FileUtils.copyFile(src, trg);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
           }	
         }
	}
}
