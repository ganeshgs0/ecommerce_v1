package com.durgasoft.ecommerce.pageUI;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.durgasoft.ecommerce.basepage.BasePage;

public class CreateLoginCustomer extends BasePage {

public static final Logger log=Logger.getLogger(CreateLoginCustomer.class.getName());
@FindBy (linkText="Sign in") WebElement lnkSignin;
@FindBy (id="email_create") WebElement txtemailAddress;
@FindBy (id="SubmitCreate") WebElement btnCreateAccnt;
@FindBy(xpath = "//h1[text()='Create an account']") WebElement txtCreateAnAccount;
@FindBy (id="customer_firstname") WebElement txtfirstname;
@FindBy (id="customer_lastname") WebElement txtlastname;
@FindBy (id="passwd") WebElement txtPassword;
@FindBy (id="years") WebElement ddyears;
@FindBy (id="months") WebElement ddmonths;
@FindBy (id="days") WebElement dddays;
@FindBy (id="firstname") WebElement txtaddrfirstname;
@FindBy (id="lastname") WebElement txtaddrlastname;
@FindBy (id="company") WebElement txtcompany;
@FindBy (id="address1") WebElement txtaddress1;
@FindBy (id="address2") WebElement txtaddress2;
@FindBy (id="city") WebElement txtcity;
@FindBy (id="id_state") WebElement ddstate;
@FindBy (id="postcode") WebElement txtpostcode;
@FindBy (id="id_country") WebElement ddcountry;
@FindBy (id="other") WebElement txtaddInfo;
@FindBy (id="phone") WebElement txthomePhone;
@FindBy (id="phone_mobile") WebElement txtmobilephone;
@FindBy (id="alias") WebElement txtassgnaddress;
@FindBy (id="submitAccount") WebElement btnRegister;
@FindBy (id="id_gender1") WebElement radiobtnMr;
@FindBy (xpath="//h1[contains(text(),'My account')]") WebElement txtMyAccount;
public void createLogin() throws Exception {
	lnkSignin.click();
	log.info("clicing on sign in "+lnkSignin.toString());
	txtemailAddress.sendKeys(getData("firstname")+getData("lastname")+
			randomNumber()+getData("domainname"));
	log.info("enetering email by using object "+txtemailAddress.toString());
	btnCreateAccnt.click();
	log.info("clicking on create account by using object "+btnCreateAccnt.toString());
	Thread.sleep(10000);
	assertEquals(txtCreateAnAccount.getText(),"CREATE AN ACCOUNT");
	System.out.println(txtCreateAnAccount.getAttribute("value"));
	System.out.println(txtCreateAnAccount.getText());
	log.info("verifying the text "+txtCreateAnAccount.getAttribute("value")
	+"by using object"+txtCreateAnAccount.toString());
	radiobtnMr.click();
	
	txtfirstname.sendKeys("mahesh");
	txtlastname.sendKeys("d");
	txtPassword.sendKeys("test3");
	ddyears.sendKeys("2009");
	ddmonths.sendKeys("May");
	dddays.sendKeys("16");
	txtaddrfirstname.clear();
	txtaddrfirstname.sendKeys("mahesh");
	txtaddrlastname.clear();
	txtaddrlastname.sendKeys("d");
	txtcompany.sendKeys("test6");
	txtaddress1.sendKeys("test7");
	txtaddress2.sendKeys("test8");
	txtcity.sendKeys("Hyderabad");
	ddstate.sendKeys("Alabama");
	txtpostcode.sendKeys("55142");
	ddcountry.sendKeys("United States");
	txtaddInfo.sendKeys("test10");
	txthomePhone.sendKeys("8561425412");
	txtmobilephone.sendKeys("7485145874");
	txtassgnaddress.sendKeys("test11");
	btnRegister.click();
	Thread.sleep(5000);
	assertEquals(txtMyAccount.getText(),"MY ACCOUNT");
	log.info("verifying the text "+txtMyAccount.getAttribute("value")
	+"by using object"+txtMyAccount.toString());
	}


public 	CreateLoginCustomer(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
	
}
