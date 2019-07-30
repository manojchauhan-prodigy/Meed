package StepDefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import gherkin.ast.Scenario;
import io.appium.java_client.android.AndroidDriver;

public class utility {
	
	
	public static void captureScreenShot(AndroidDriver ldriver){
		// Take screenshot and store as a file format             
		
		
		File src= ((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);           
		try {
		// now copy the  screenshot to desired location using copyFile method
		 
		FileUtils.copyFile(src, new File("output/" +System.currentTimeMillis()+".png"));                            
		
		} catch (IOException e)
		 
		{
		  System.out.println(e.getMessage()) ;
		 }
		  
	}	
	
}
