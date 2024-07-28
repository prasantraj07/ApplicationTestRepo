package TestRunner;

//dryRun=true then code mapping will happen & no execution
//dryRun=false then both code mapping & execution will happen
//checks whether all steps written in feature file is implemented in StepDefinition class or not when dryRun=true:
//monochrome = true -> for printing the o/p in Readable format
//We'll use Junit imports for junit execution, TestNG imports for testng execution.

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;



//JUnit Execution(cucumber-junit dependency):


@RunWith(Cucumber.class)
@CucumberOptions
		(
		//***Code for executing multiple feature files:
		//features = {".//Features/Customers.feature", ".//Features/LoginFeature.feature"},
				
		//executing Single feature file:
		features = ".//Features/LoginFeature.feature",
		glue = "StepDefinition",
		dryRun = false,
		monochrome = true,
		tags = "@Sanity", 	//scenario with this Tag will be executed
		
		//all scenarios with either 'Sanity' or 'regression' tag will get executed:
		//tags = "@Sanity" or "@regression"
		
		//only scenarios with both 'Sanity' & 'regression' tags will get executed:
		//tags = "@Sanity" and "@regression"	
		plugin = {"pretty", "html:target/cucumber-reports/Reports1.html"}
		
		)
	


//TestNG Execution:

/*
@CucumberOptions
		(
		features = ".//Features/LoginFeature.feature",
		glue = "StepDefinition",
		dryRun = false,
		monochrome = true,
		tags = "@Sanity",
		plugin = {"pretty", "html:target/cucumber-reports/Reports1.html"}
		
		)
*/


public class Run
{
	/*
	 this class will be empty
	 */

}

//Cucumber-html report code:
//plugin = {"pretty", "html:target/cucumber-reports/Reports1.html"}

//Cucumber-json report code:
//plugin = {"pretty", "json:target/cucumber-reports/Report_json.json"}

//XML report code:
//"pretty", "junit:target/cucumber-reports/Report_xml.xml"
