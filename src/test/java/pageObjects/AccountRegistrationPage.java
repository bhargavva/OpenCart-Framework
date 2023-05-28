package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(name = "firstname")
	WebElement firstName_TextField;
	
	@FindBy(name = "lastname")
	WebElement lastName_TextField;
	
	@FindBy(name = "email")
	WebElement email_TextField;
	
	@FindBy(name = "telephone")
	WebElement telephone_TextField;
	
	@FindBy(name = "password")
	WebElement password_TextField;
	
	@FindBy(id = "input-confirm")
	WebElement confirmPassword_TextField;
	
	@FindBy(name = "agree")
	WebElement agree_CheckBox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continue_Button;
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement create_Account_confirm_Msg;
	
	public void setFirstName(String firstName) {
		firstName_TextField.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		lastName_TextField.sendKeys(lastName);
	}
	
	public void setEmail(String email) {
		email_TextField.sendKeys(email);
	}
	
	public void setPhoneNumber(String phoneNumber) {
		telephone_TextField.sendKeys(phoneNumber);
	}
	
	public void setPassword(String password) {
		password_TextField.sendKeys(password);
	}
	
	public void setConfirmPassword(String password) {
		confirmPassword_TextField.sendKeys(password);
	}
	
	public void setPrivacyPolicy() {
		agree_CheckBox.click();
	}
	
	public void clickContinue() {
		continue_Button.click();
	}
	
	public String getConfirmationMessage() {
		try {
			return create_Account_confirm_Msg.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
	
}
