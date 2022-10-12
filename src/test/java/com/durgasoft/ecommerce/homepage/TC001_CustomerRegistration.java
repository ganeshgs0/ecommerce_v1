package com.durgasoft.ecommerce.homepage;

import org.testng.annotations.Test;

import com.durgasoft.ecommerce.basepage.BasePage;
import com.durgasoft.ecommerce.pageUI.CreateLoginCustomer;
import com.relevantcodes.extentreports.LogStatus;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TC001_CustomerRegistration extends BasePage {
	public static final Logger log=Logger.getLogger(TC001_CustomerRegistration.class.getName());
  @Test
  public void CustomerRegistration() throws Exception {
	  log.info("*****starting TC001_CustomerRegistration *******");
	  CreateLoginCustomer login=new CreateLoginCustomer(driver);
	  login.createLogin();
	  log.info("**********ending TC001_CustomerRegistration ********");
	  }
  @BeforeClass
  public void beforeTest() throws Exception {
	browserLaunch(getData("browser"),getData("url"));
  }

  @BeforeMethod
  public void startReport(Method result) {
	  test=extent.startTest(result.getName());
	  test.log(LogStatus.INFO, result.getName()+"test is started");
  }
  
  @AfterMethod
  public void endReport(ITestResult result) {
    if(result.getStatus()==ITestResult.SUCCESS)
    test.log(LogStatus.PASS, result.getName()+"test is passed");
	else if (result.getStatus()==ITestResult.FAILURE)
	test.log(LogStatus.FAIL, result.getName()+"test is failed and reason is "+result.getThrowable());
	else if (result.getStatus()==ITestResult.SKIP)
	test.log(LogStatus.SKIP, result.getName()+"test is failed and reason is "+result.getThrowable());
  } 
  public void closeBrowser() {
	  driver.quit();
	  extent.endTest(test);
	  extent.flush();
  }
  @AfterClass
  public void afterClass() {
	  closeBrowser();
  }
}
