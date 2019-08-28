package TestRunner;


import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		
 features = "src/test/Feature",
 glue= {"StepDefination"},
 plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"},
 tags = {"@SmokeTest"},
 monochrome = true
		 
 )
 
public class TestRunner {

	@AfterClass
	public static void setup()
	{	
	Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
	Reporter.setSystemInfo("User Name", "Manoj");
	Reporter.setSystemInfo("Application Name", "Meed Mobile App ");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "UAT");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}	
}
