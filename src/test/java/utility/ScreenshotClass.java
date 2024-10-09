package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import io.qameta.allure.Attachment;

public class ScreenshotClass {

	
	public ScreenshotClass(String classname, WebDriver driver) {
		//this.driver = driver;
		System.out.println("Print driver in screenshot class : " +driver);
		String timestamp = new SimpleDateFormat("yyyy-MM-dd__hh-mm-ss").format(new Date());
		TakesScreenshot takesrc = (TakesScreenshot)driver;
		
		File scr = takesrc.getScreenshotAs(OutputType.FILE);
		
		
		try {
			FileUtils.copyFile(scr, new File("./Screenshots/"+classname+" "+timestamp+".png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
