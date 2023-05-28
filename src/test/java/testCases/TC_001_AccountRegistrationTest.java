package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	@Test(groups = {"Regression", "Master"})
	void test_Account_Registration() {
		logger.debug("application logs......");
		logger.info("*****  Starting TC_001_test_Account_Registration*****");
		
		try {
			HomePage homePage = new HomePage(driver);
			homePage.clickMyAccount();
			logger.info("Clicked on My Account Link");
			homePage.clickRegister();
			logger.info("Clicked on My Register Link");
			AccountRegistrationPage registerForm = new AccountRegistrationPage(driver);
			logger.info("Providing all customer data.");
			registerForm.setFirstName("abc");
			registerForm.setLastName("xyz");
			registerForm.setEmail(generateRandomAlphaNumeric(7)+"@gmail.com");
			registerForm.setPhoneNumber(generateRandomNumber(10));
			String password = generateRandomAlphaNumeric(10);
			registerForm.setPassword(password);
			registerForm.setConfirmPassword(password);
			registerForm.setPrivacyPolicy();
			logger.info("Clicked on Continue");
			registerForm.clickContinue();
			String confirmationMessage = registerForm.getConfirmationMessage();
			
			logger.info("Verifying expected message");
			Assert.assertEquals(confirmationMessage, "Your Account Has Been Created!");

		} catch (Exception e) {
			logger.error("test failed");
			Assert.fail();
		}
		logger.info("*****  Finished TC_001_test_Account_Registration*****");
	}

}
