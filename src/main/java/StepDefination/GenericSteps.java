package StepDefination;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import cucumber.api.java.en.Given;
import io.appium.java_client.MobileElement;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;


public class GenericSteps {

	public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    public RespositoryParser parser;
    utility screen = new utility();
    DesiredCapabilities caps = new DesiredCapabilities();
    
    @Given("^user launches the app in \"(.*?)\" device$")
    public void user_launches_the_app_in_device(String arg1) throws Throwable {
    	parser = new RespositoryParser("src/test/resources/objectRepository.properties");	
    	
    	
    	if(arg1.equalsIgnoreCase("Android"))
    	{
    	
    	File f = new File ("src");
        File fs = new File (f,"app-debug.apk");
      
        caps.setCapability("deviceName", "Nexus S");
        caps.setCapability("udid", "emulator-5554");               //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
//        caps.setCapability("app", "fs.getAbsolutePath()");
//        caps.setCapability("app", "fs.getAbsolutePath()");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "7.0");
        caps.setCapability("skipUnlock","true");
       caps.setCapability("appPackage", "com.uat.meedbankingclub");
        caps.setCapability("appActivity","com.uat.meedbankingclub.MainActivity");
        caps.setCapability("noReset","false");
        caps.setCapability("unicodeKeyboard", true);
       caps.setCapability("resetKeyboard", true);
       caps.setCapability("autoAcceptAlerts", true);
   	caps.setCapability("autoDismissAlerts", true);
   	
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);     
       // driver.pressKey(new KeyEvent(AndroidKey.BACK));
      
                
    	}
    	else
    	{
    		System.out.println("iOS is yet to be implemented");
    	}
    	
    utility.captureScreenShot(driver);
	
    }
    
    @Given("^user enters email \"(.*?)\"$")
    public void user_enters_email(String arg1) throws Throwable {
    	wait = new WebDriverWait(driver, 40);
    	wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className("android.widget.EditText"))).sendKeys(arg1);
    	utility.captureScreenShot(driver);
    }
    
    
    @Given("^user clicks on button \"([^\"]*)\"$")
    public void user_clicks_on_button(String button_name) throws Throwable {
    	 
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(parser.getbjectLocator(button_name))).click();  
    	utility.captureScreenShot(driver);
    	
    }
    
    @Given("^user clicks on label \"([^\"]*)\"$")
    public void label(String label_name) throws Throwable {
    	 
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(parser.getbjectLocator(label_name))).click();  
    	utility.captureScreenShot(driver);
    	
    }
   
    @Given("^user enters text \"([^\"]*)\" in textbox \"([^\"]*)\"$")
    public void user_enters_text_in_textbox(String text_value, String textbox_name) throws Throwable {
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(parser.getbjectLocator(textbox_name))).clear();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
                (parser.getbjectLocator(textbox_name))).sendKeys(text_value);
    	
    	utility.captureScreenShot(driver);
    }
   
    
    @Given("^user selects option \"([^\"]*)\"  from the dropdown \"([^\"]*)\"$")
    public void user_selects_option_from_the_dropdown(String dropdown_value, String dropdown_name) throws Throwable {
    	 wait.until(ExpectedConditions.visibilityOfElementLocated
    			 (parser.getbjectLocator(dropdown_name))).click();
         //Select Weekly Radio button
         wait.until(ExpectedConditions.visibilityOfElementLocated
        		 (parser.getbjectLocator(dropdown_value))).click();
         utility.captureScreenShot(driver);
          
    }
    
    
 /*   @Given("^user select radio button \"([^\"]*)\"$")
    public void user_select_radio_button(String recipient) throws Throwable {
        
    	driver.findElement(By.xpath("//android.widget.CheckBox[@text='" +"receipient']")).click();
    	
    	utility.captureScreenShot(driver);
    	
    }
    */

    @Given("^user validates \"([^\"]*)\" field with expected value as \"([^\"]*)\"$")
    public void user_validates_field_with_expected_value_as(String actual, String expected) throws Throwable {
    	utility.captureScreenShot(driver);
    	actual = actual+ "_value";
    	String actual_argument = wait.until(ExpectedConditions.visibilityOfElementLocated
   			 (parser.getbjectLocator(actual))).getText();
    
    		Assert.assertEquals(expected, actual_argument);
    		
    }
   
    
    @Given("^user swipes right to select \"([^\"]*)\"$")
    public void user_swipes_right_to_select(String account) throws Throwable {
    	
    	 TouchAction touchAction = new TouchAction(driver);    //for touch actions on mobile devices
    	if(account.equalsIgnoreCase("SAVINGS"))
	{
    	//action.press(startx,starty).waitAction(1000).moveTo(startx,endy).release().perform();    	
        touchAction.longPress(PointOption.point(290, 309)).moveTo(PointOption.point(0, 309)).release().perform();
    }
    	else
    	{
    		touchAction.longPress(PointOption.point(290, 540)).moveTo(PointOption.point(0, 540)).release().perform();	
    	}
    	utility.captureScreenShot(driver);
    }
    
    
    @Given("^user clicks on link \"([^\"]*)\"$")
    public void user_clicks_on_link(String linkname) throws Throwable {
       
    	 wait.until(ExpectedConditions.visibilityOfElementLocated
    			 (parser.getbjectLocator(linkname))).click();
    	 utility.captureScreenShot(driver);
    	
    }
    
    @Given("^user selects checkbox \"([^\"]*)\"$")
    public void user_selects_checkbox(String checkbox_name) throws Throwable {
    	wait.until(ExpectedConditions.visibilityOfElementLocated
   			 (parser.getbjectLocator(checkbox_name))).click();
   	 utility.captureScreenShot(driver);
        
    }

    @Given("^user waits for \"(.*?)\" seconds$")
    public void user_waits_for_seconds(long arg1) throws Throwable 
    {
       arg1 = arg1*1000;
    	Thread.sleep(arg1);
    	utility.captureScreenShot(driver);
    } 
    
    @Given("^user wats for \"([^\"]*)\" seconds$")
    public void user_wats_for_seconds(String arg1) throws Throwable {
    	List<MobileElement> elements = driver.findElements(By.className("android.widget.EditText"));
        System.out.println("Number of elements:" +elements.size());

        for (int i=0; i<elements.size();i++)
        {
          System.out.println("Radio button text:" + elements.get(i).getAttribute("text"));
          elements.get(1).sendKeys("meedqe75@yopmail.com");
         
        }
    }
    
}	



    
	

