/*
 * test page
 * 
 */


package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage;
	
	public LoginPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUP()
	{
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPagetitleTest()
	{
		String expected_title="CRMPRO  - CRM software for customer relationship management, sales, and support.";
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, expected_title);
		
	//	Assert.assertTrue(title.contains(expected_title));
		
	}
	
	@Test(priority=2)
	public void crmLogoTest()
	{
		Assert.assertTrue(loginPage.validateCRMLogo());
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
