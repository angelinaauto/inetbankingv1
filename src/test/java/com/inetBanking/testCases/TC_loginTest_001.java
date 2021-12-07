package com.inetBanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.loginPage;

public class TC_loginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("Entered the url");
		loginPage lp = new loginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			CaptureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}

}
