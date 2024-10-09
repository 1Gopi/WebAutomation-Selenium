package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import base.ExcelFileReader;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import objrepo.LoginPageObj;

@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginPage extends BaseClass {
	
	ExcelFileReader excelreader = new ExcelFileReader();
	
	/*
	 * public LoginPage() { System.out.println("Invalid user : "
	 * +excelreader.user[1] + "Inavlid Password :" +excelreader.pass[1]); }
	 */
	
	@Test(priority=2, description="Invalid Login scenario")
	@Description("Login page Test with invalid logins")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Invalid credentials login to site test")
	public void InvalidLoginTest() {
		LoginPageObj loginobj = new LoginPageObj();
		System.out.println("Invalid user : "+ excelreader.user +" Invalid password : "+excelreader.pass);
		try {
			System.out.println("inside try block of InvalidLogin test");
			//loginobj.InvalidCredentials("admin5", excelreader.pass);
			loginobj.username("admin5");
			loginobj.password(excelreader.pass);
			loginobj.clickLogin();
			Thread.sleep(10000);
			Boolean val =loginobj.invalidCheck();
			Assert.assertEquals(true, val);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Inside catch blcok of Invalid login test");
			e.printStackTrace();
		}
		/*
		 * if(res == "Invalid Credentials") { System.out.println("Invalid credentials");
		 * } else throw new RuntimeException("Invalid password login defect");
		 */
	}

	
	@Test(priority=1, description="Valid Login scenario", groups= {"santiy","Regression"})
	@Description("Login page Test with valid logins")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Valid credentials login to site")
	public void LoginTest() throws Exception {
		LoginPageObj loginobj = new LoginPageObj();
		String Url = driver.getCurrentUrl();
		
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofMillis(5000));
		wt.until(ExpectedConditions.elementToBeClickable(loginobj.getUsernamefield()));
		//loginobj2.getUsernamefield();
		loginobj.username(excelreader.user);
		WebDriverWait wt2 = new WebDriverWait(driver, Duration.ofMillis(5000));
		wt2.until(ExpectedConditions.elementToBeClickable(loginobj.getPassword()));
		loginobj.password(excelreader.pass);
		loginobj.clickLogin();
		
		Thread.sleep(5000);
		loginobj.Logout(Url);
	}
	
	
	@Test(priority=3,description="Forgot password")
	@Description("Forgot Password functionality check")
	@Severity(SeverityLevel.NORMAL)
	@Story("password reset")
	public void forgotPassword() {
		LoginPageObj loginobj = new LoginPageObj();
		loginobj.forgotPassword();
	}
	
}
