package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAcccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	//If we have data provider in the same class dataProvider attribute is enough, 
	//If we have data provider in a different class we also need to add dataProviderClass attribute as well. 
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_loginDDT(String email, String password, String expectedResult) {
		try {
			
			logger.info("**** Starting TC_003_LoginDDT ****");
			
			HomePage homePage = new HomePage(driver);
			homePage.clickMyAccount();
			homePage.clickLogin();
			
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(email);
			loginPage.setPassword(password);
			loginPage.clickLoginButton();
			MyAcccountPage myAcccountPage = new MyAcccountPage(driver);
			//Assert.assertTrue(myAcccountPage.isMyAccountPageExists(), "Login Failed: Invalid Login data");
			
			if(expectedResult.equals("Valid")) {
				if(myAcccountPage.isMyAccountPageExists()) {
					myAcccountPage.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			} else if(expectedResult.equals("Invalid")) {
				if(myAcccountPage.isMyAccountPageExists()) {
					myAcccountPage.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
			
		} catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("**** Finished TC_003_LoginDDT ****");
	}
}
