package StepDefinition;

//In realtime, we'll have multiple Step definitions files.

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PackageObjects.AddNewCustomer;
import PackageObjects.LoginPage;
import PackageObjects.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.core.logging.Logger;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;



//Child Class of BaseClass:
public class StepDef extends BaseClass	
{
	
	public WebDriver driver;
	public LoginPage loginpage;
	public AddNewCustomer addNewCustPage;
	public SearchCustomerPage searchCustPage;
	
	
	
	
	//-----------------------Login functionality-----------------------------
	
	 
	@Before("@Sanity")	
	public void setup() throws IOException 
	{
				
		readConfig = new ReadConfig();
		log = LogManager.getLogger("StepDef");	//initialize logger
		
		System.out.println("Setup-Sanity method executed");
		
		String browser = readConfig.getBrowser();
		
		switch(browser.toLowerCase()) 
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "msedge":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		
		case "Firefox":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		default:
			driver = null;
			break;
			
		}
		
		
		log.info("Setup executed....");
		
		
	}
	
	//@Before("@Sanity") 	//we can use order keyword in @Before annotation to prioritize execution
	//@Before(order=0)
	public void setup2() 
	{
		System.out.println("Setup2 method executed");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() 
	{
		
		loginpage = new LoginPage(driver);	//we have to pass WebDriver object i.e. 'driver'
		addNewCustPage = new AddNewCustomer(driver);
		searchCustPage = new SearchCustomerPage(driver);
		
		log.info("Chrome Browser launched");
	    
	}

	@When("User opens URL {string}")	//we should not change given, when, then annotations
	public void user_opens_url(String url)	//this url will come from feature file
	{
		driver.get(url);
	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) 
	{
		loginpage.enterEmail(emailadd);
		loginpage.enterPassword(password);
		
		log.info("email address and password entered");
		
	    
	}

	@When("Click on Login")
	public void click_on_login() 
	{
		loginpage.clickOnLoginButton();
		log.info("Clicked on Login button");
	    
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) 
	{
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals(expectedTitle)) 
		{
			
			log.warn("Login feature: Page title matched");
			Assert.assertTrue(true);	//pass
			
		}
		else 
		{
			
			Assert.assertTrue(false);	//fail
			log.warn("Login feature: Test failed");
		}
	    
	}

	@When("User click on Logout link")
	public void user_click_on_logout_link() 
	{
		loginpage.clickOnLogOutButton();
		log.info("User clicked on logout link");
		
	}
	

	
	@Then("Close the Browser")
	public void close_the_browser() 
	{
		driver.close();
		//driver.quit();
		log.info("Browser closed");
	    
	}
	
	
	
	@After
	public void tearDown() 
	{
		System.out.println("Tear down method executed....");
		driver.quit();
		
	}
	
	
	//-----------------------Add New Customer functionality-----------------------------
	
	//public AddNewCustomer addNewCustPage;
	
	/*
	 
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() 
	{
	    String actualTitle = addNewCustPage.getPageTitle();
	    String expectedTitle = "Dashboard / nopCommerce administration";
	    
	    if(actualTitle.equals(expectedTitle)) 
	    {
	    	Assert.assertTrue(true);
	    }
	    else 
	    {
	    	Assert.assertTrue(false);
	    }
		
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException 
	{
		addNewCustPage.clickOnCustomersMenu();
		Thread.sleep(5000);
	    
	}
	

	@When("click on Customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException 
	{
		addNewCustPage.clickOnCustomersMenuItem();
		Thread.sleep(5000);
		
	}

	@When("click on Add new button")
	public void click_on_add_new_button() 
	{
		addNewCustPage.clickOnAddnew();
	   
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() 
	{
		String actualTitle = addNewCustPage.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";
		
		if(actualTitle.equals(expectedTitle)) 
	    {
	    	Assert.assertTrue(true);	//pass
	    }
	    else 
	    {
	    	Assert.assertTrue(false);	//fail
	    }
	    
	}

	@When("User enter customer info")
	public void user_enter_customer_info() 
	{
		//addNewCustPage.enterEmail("cs124@gmail.com");
		addNewCustPage.enterEmail(generateEmailId() + "@gmail.com");
		addNewCustPage.enterPassword("test1");
		addNewCustPage.enterFirstName("Prachi");
		addNewCustPage.enterLastName("Gupta");
		addNewCustPage.enterGender("Female");
		addNewCustPage.enterDob("6/13/1988");
		addNewCustPage.enterCompanyName("CodeStudio");
		addNewCustPage.enterAdminContent("Admin Content");
		addNewCustPage.enterManagerOfVendor("Manager");
		
	    
	}

	@When("click on Save button")
	public void click_on_save_button() 
	{
		addNewCustPage.clickOnSave();
	    
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmMessage) 
	{
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		
		if(bodyTagText.contains(expectedConfirmMessage)) 
		{
			Assert.assertTrue(true);
			
		}
		else 
		{
			Assert.assertTrue(false);
			
		}
	    
	}
	*/
	//-----------------------Search Customer functionality-----------------------------
	//public SearchCustomerPage searchCustPage;
	
	/*
	
	@When("Enter customer Email")
	public void enter_customer_email() 
	{
		searchCustPage.enterEmailAdd("victoria_victoria@nopCommerce.com");
	}

	@When("Click on Search button")
	public void click_on_search_button() throws InterruptedException 
	{
		searchCustPage.clickOnSearchBtn();
		Thread.sleep(5000);
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() 
	{
		String expectedEmail = "victoria_victoria@nopCommerce.com";
		
		Assert.assertTrue(searchCustPage.searchCustomerByEmail(expectedEmail));
		
	//	
	//	if(searchCustPage.searchCustomerByEmail(expectedEmail) == true) 
	//	{
	//		Assert.assertTrue(true);
	//	}
	//	else 
	//	{
	//		Assert.assertTrue(false);
	//	}
		
	    
	}
	
	*/

	//-----------------------Search Customer by Name functionality-----------------------------
	//public SearchCustomerPage searchCustPage;
	
	/*
	@When("Enter customer FirstName")
	public void enter_customer_first_name() 
	{
		searchCustPage.enterFirstName("Victoria");
	    
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() 
	{
		searchCustPage.enterLastName("Bechcham");
	   
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() 
	{
		
		String expectedName = "Victoria Bechcham";
		
		Assert.assertTrue(searchCustPage.searchCustomerByName(expectedName));
	    
	}
	
	
	@After(order=1)	
	public void tearDown1() 
	{
		System.out.println("Tear down method1 executed....");
		driver.quit();
		
	}
	
	
	@After()	
	public void tearDown(Scenario sc) throws IOException 
	{
		System.out.println("Tear down method executed....");
		
		if(sc.isFailed() == true) 
		{
			String fileWithPath = "C:\\Users\\Asus\\eclipse\\java-2023-09\\eclipse\\Testing\\CucumberFramework\\Screenshots\\failedscreenshot.png";
			TakesScreenshot scrshot = ((TakesScreenshot) driver);
			
			File srcFile = scrshot.getScreenshotAs(OutputType.FILE);
			
			File destFile = new File(fileWithPath);
			
			FileUtils.copyFile(srcFile, destFile);
			
		}
		driver.quit();
		
	}
	
	*/
	
	
	/*
	@BeforeStep
	public void beforeStepMethodDemo() 
	{
		System.out.println("This is before step.....");
		
	}
	
	@AfterStep
	public void afterStepMethodDemo() 
	{
		System.out.println("This is after step.....");
		
	}
	*/
	
	


}



