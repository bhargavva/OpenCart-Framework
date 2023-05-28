package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAcccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	
	@Test(groups = {"Sanity", "Master"})
	public void test_login() {
		
		try {
			logger.info("**** Starting TC_002_LoginTest****");
			HomePage homePage = new HomePage(driver);
			homePage.clickMyAccount();
			logger.info("Clicked on My Account Link on Home Page");
			homePage.clickLogin();
			logger.info("****Clicked on Login Link in Home Page");
			
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(resourceBundle.getString("email"));
			loginPage.setPassword(resourceBundle.getString("password"));
			loginPage.clickLoginButton();
			logger.info("Clicked on login button");
			MyAcccountPage myAcccountPage = new MyAcccountPage(driver);
			Assert.assertTrue(myAcccountPage.isMyAccountPageExists(), "Login Failed: Invalid Login data");
			
		} catch (Exception e) {
			Assert.fail();
		}
	
		logger.info("**** Finished TC_002_LoginTest ****");
	}
}
