package PackageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rDriver) 
	{
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
		
	}
	
	//Elements:
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement loginBtn;
	
	@FindBy(linkText = "Logout")
	WebElement logout;
	
	
	//Actions:
	
	public void enterEmail(String emailAdd) 
	{
		email.clear();
		email.sendKeys(emailAdd);		//sendKeys method will have same argument as enterEmail method
		
		
	}
	
	public void enterPassword(String pwd) 
	{
		password.clear();
		password.sendKeys(pwd);
		
	}
	
	public void clickOnLoginButton() 
	{
		loginBtn.click();
		
	}
	
	public void clickOnLogOutButton() 
	{
		logout.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
