package PackageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage 
{
	
WebDriver ldriver;
	
	//Constructor:
	public SearchCustomerPage(WebDriver rDriver) 
	{
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
		
	}
	
	//Find web elements on the web page:
	
	@FindBy(id="SearchEmail")
	WebElement emailAdd;
	
	@FindBy(id="search-customers")
	WebElement searchBtn;
	
	@FindBy(xpath="//table[@role='grid']")
	WebElement searchResult;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows; 
	
	//@FindBy(xpath="//table[@id='customers-grid']//tbody/td")
	//List<WebElement> tableColumns;
	
	@FindBy(id="SearchFirstName")
	WebElement firstName;
	
	@FindBy(id="SearchLastName")
	WebElement lastName;
	
	
	
	//Action methods:
	
	public void enterEmailAdd(String email) 
	{
		emailAdd.sendKeys(email);
		
	}
	
	public void clickOnSearchBtn() 
	{
		searchBtn.click();
		
	}
	
	public boolean searchCustomerByEmail(String email) 
	{
		boolean found = false;
		
		//total no. of rows in a grid:
		int ttlRows = tableRows.size();
		
		//total no. of columns:
		//int ttlColumns = tableColumns.size();
		
		for(int i=1;i<=ttlRows; i++)	//to iterate all the rows of the grid
		{
			WebElement webElementEmail = ldriver.findElement(By.xpath
			("//table[@id='customers-grid']//tbody/tr["+i+"1]/td[2]"));
			
			String actualEmailAdd = webElementEmail.getText();
			
			if(actualEmailAdd.equals(email)) 
			{
				found = true;
			}
			
		}
		
		return found;
	}
	
	//-----------------------Search Customer by Name functionality-----------------------------
	
	public void enterFirstName(String firstNameText) 
	{
		firstName.sendKeys(firstNameText);
		
	}
	
	public void enterLastName(String lastNameText) 
	{
		lastName.sendKeys(lastNameText);
		
	}
	
	public boolean searchCustomerByName(String name) 
	{
		boolean found = false;
		
		//total no. of rows in a grid:
		int ttlRows = tableRows.size();
		
		
		for(int i=1;i<=ttlRows; i++)	//to iterate all the rows of the grid
		{
			WebElement webElementName = ldriver.findElement(By.xpath
			("//table[@id='customers-grid']//tbody/tr["+i+"1]/td[3]"));
			
			String actualName = webElementName.getText();
			
			if(actualName.equals(name)) 
			{
				found = true;
				break;
			}
			
		}
		
		return found;
	}
	
	
	

}






