package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ParentPage;

public class SignInPage extends ParentPage {
	
	WebDriver pageDriver;
	
	@FindBy(id="identifierId")
	WebElement emailIdTextbox;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement nextButton;
	
	@FindBy(name="password")
	WebElement passwordTextbox;

	public SignInPage(WebDriver d) {
		super(d);
		pageDriver = d;
		PageFactory.initElements(pageDriver, this);
	}
	
	public String getEmailId() {
		/*waitForElement(emailIdTextbox, Condition.VISIBLE);
		return emailIdTextbox.getText();*/
		String text = getText(emailIdTextbox);
		return text;
	}
	
	public void setEmailId(String emailId) {
		enterText(emailIdTextbox, emailId);
	}
	
	public String getPassword() {
		return getText(passwordTextbox);
	}
	
	public void setPassword(String password) {
		enterText(passwordTextbox, password);
	}

	public void clickNext() {
		click(nextButton);
	}
	
	public HomePage clickSignIn() {
		click(nextButton);
		return new HomePage(pageDriver);
	}
}