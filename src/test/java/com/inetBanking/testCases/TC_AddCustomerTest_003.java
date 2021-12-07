package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.loginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		loginPage lp = new loginPage(driver);

		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();

		Thread.sleep(5000);

		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		logger.info("providing customer details....");

		addcust.custName("Daisy");
		addcust.custgender("female");
		addcust.custdob("02", "18", "1985");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("500048");
		addcust.custtelephoneno("9866372627");

		String email = randomestring() + "@gmail.com";
		addcust.custemailid(email);

		addcust.custpassword("123456");
		addcust.custsubmit();

		Thread.sleep(5000);

		logger.info("validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");

		} else {
			logger.info("test case failed....");
			CaptureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}

	}

	
}
