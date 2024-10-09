package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseClass;
import io.qameta.allure.Attachment;
import utility.ScreenshotClass;

public class WebDriverListeners extends BaseClass implements ITestListener {

	
	  @Attachment(value="page failed screensot", type = "image/png") 
	  public byte[] takeScreenshot() { 
		  return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		  
	  }
	 
	@Override
	public void onTestFailure(ITestResult result) {
		String Classname = result.getMethod().getMethodName();
		// WebDriver driver = (WebDriver) context.getAttribute("driver");
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver != null) {
			new ScreenshotClass(Classname, driver);
		}
	}

}
