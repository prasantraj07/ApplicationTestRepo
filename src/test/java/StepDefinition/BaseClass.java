package StepDefinition;

//BaseClass is used to maintain common methods/variables:


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import PackageObjects.AddNewCustomer;
import PackageObjects.LoginPage;
import PackageObjects.SearchCustomerPage;
import Utilities.ReadConfig;

import org.apache.logging.log4j.*;
import java.util.Properties;


//Parent Class
public class BaseClass	
{
	public static WebDriver driver;
	public LoginPage loginpage;
	public AddNewCustomer addNewCustPage;
	public SearchCustomerPage searchCustPage;
	public static org.apache.logging.log4j.Logger log;
	public ReadConfig readConfig;
	
	
	
	//creating Random emailId code:
	
	public String generateEmailId() 
	{
		return (RandomStringUtils.randomAlphabetic(5));
		
	}

}
