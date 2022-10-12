package com.durgasoft.ecommerce.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Retry implements IRetryAnalyzer {
	
int retrycnt=0;
int maxretrycnt=3;
public boolean retry(ITestResult result) {
	if(retrycnt<maxretrycnt) {		
		Reporter.log("Retrying test "+result.getName()+"with status "
		+getResultStatusName(result.getStatus())+"for the "+(retrycnt+1)+"times");
		retrycnt++;
		return true;
	}
return false;	
			}

public String getResultStatusName(int status) {
	String resultName=null;
	if(status==1)
	resultName="SUCCESS";
	if(status==2)
	resultName="FAIL";
	if(status==3)
	resultName="SKIP";
	return resultName;
}
}
