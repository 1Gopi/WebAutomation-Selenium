package objrepo;

import java.time.Duration;
import java.util.NoSuchElementException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class LoginPageObj extends BaseClass {

	public LoginPageObj() {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
	private WebElement usernamefield;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
	private WebElement password;

	@FindBy(xpath = "//button[contains(@class,'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button')]")
	private WebElement LoginButton;

	@FindBy(xpath = "//p[contains(@class,'oxd-text oxd-text--p orangehrm-login-forgot-header')]")
	private WebElement forgotpassword;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
	private WebElement InvalidCred;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span")
	private WebElement UsernameDropdown;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul")
	private WebElement UsernameDropdownBox;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a")
	private WebElement LogOut;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span")
	private WebElement UsernameRequired;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span")
	private WebElement PasswordRequired;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/div/form/div[1]/div/div[2]/input")
	private WebElement forgotpasswordUsernameField;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/div/form/div[2]/button[1]")
	private WebElement forgotpasswordCancel;
	
	@FindBy(xpath="/html/body/div/div[1]/div[1]/div/form/div[2]/button[2]")
	private WebElement forgotpasswordResetPassword;
	
	@FindBy(xpath="/html/body/div/div[1]/div[1]/div/h6")
	private WebElement forgotpassSuccess;
	
	@FindBy(xpath="//h6[contains(@class,'oxd-text oxd-text--h6 orangehrm-forgot-password-title')]")
	private WebElement forgotpassuserscreen;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/div/form/div[1]/div/span")
	private WebElement forgotpassusernamefiledRequired;
	
	
	
	public WebElement getUsernameDropdown() {
		return UsernameDropdown;
	}


	public void setUsernameDropdown(WebElement usernameDropdown) {
		UsernameDropdown = usernameDropdown;
	}


	public WebElement getUsernameDropdownBox() {
		return UsernameDropdownBox;
	}


	public void setUsernameDropdownBox(WebElement usernameDropdownBox) {
		UsernameDropdownBox = usernameDropdownBox;
	}


	public WebElement getLogOut() {
		return LogOut;
	}


	public void setLogOut(WebElement logOut) {
		LogOut = logOut;
	}


	public WebElement getForgotpassword() {
		return forgotpassword;
	}


	public void setForgotpassword(WebElement forgotpassword) {
		this.forgotpassword = forgotpassword;
	}


	public WebElement getInvalidCred() {
		return InvalidCred;
	}


	public void setInvalidCred(WebElement invalidCred) {
		InvalidCred = invalidCred;
	}


	public WebElement getUsernameRequired() {
		return UsernameRequired;
	}


	public void setUsernameRequired(WebElement usernameRequired) {
		UsernameRequired = usernameRequired;
	}


	public WebElement getPasswordRequired() {
		return PasswordRequired;
	}


	public void setPasswordRequired(WebElement passwordRequired) {
		PasswordRequired = passwordRequired;
	}

	

	public void username(String user) {
		
				usernamefield.clear();
				usernamefield.click();
				usernamefield.sendKeys(user);
				
		}
	

	public WebElement getUsernamefield() {
		return usernamefield;
	}

	public void setUsernamefield(WebElement usernamefield) {
		this.usernamefield = usernamefield;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		LoginButton = loginButton;
	}

	public void password(String pass) {
		Boolean fl2 = true;
		while(fl2) {
			if(password.isEnabled()) {
				password.clear();
		password.click();
		password.sendKeys(pass);
		fl2 = false;
			}
		}
	}

	public void clickLogin() {
		Boolean fl3 = true;
		while(fl3) {
			if(LoginButton.isEnabled()) {
				LoginButton.click();
				fl3 = false;
			}
		}
		
	}

	public void clickForgotPassword() {
		forgotpassword.click();
	}

	

	public Boolean invalidCheck() {
		if(!InvalidCred.isDisplayed()) {
			System.out.println("Validaton for invaild credentials not dispalayed");
		}
		return InvalidCred.isDisplayed();
	}
	
	
	public String usernameRequired() {
		if(!UsernameRequired.isDisplayed()) {
			System.out.println("Validation for username not dispalyed");
		}
		return UsernameRequired.getText();
	}
	
	public String passwordReaquired() {
		if(!PasswordRequired.isDisplayed()) {
			System.out.println("Validation for Password not dispalyed");
		}
		return PasswordRequired.getText();
	}
	
	public void Logout(String loginPageUrl) {
		UsernameDropdown.click();
		Actions act = new Actions(driver);
		act.moveToElement(UsernameDropdownBox).moveToElement(LogOut).click().build().perform();
		String CurrentUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginPageUrl, CurrentUrl);
	}
	
	public void forgotPassword() {
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
		        .withTimeout(Duration.ofSeconds(5000))
		        .pollingEvery(Duration.ofSeconds(5))
		        .ignoring(NoSuchElementException.class);
		
		forgotpassword.click();
		SoftAssert asrt = new SoftAssert();
		fluentWait.until(ExpectedConditions.visibilityOf(forgotpassuserscreen));
		asrt.assertEquals(forgotpassuserscreen.getText(),"Reset Password");
		fluentWait.until(ExpectedConditions.elementToBeClickable(forgotpasswordResetPassword)).click();
		
		//fluentWait.until(ExpectedConditions.visibilityOf(forgotpassusernamefiledRequired));
		//asrt.assertEquals(forgotpassusernamefiledRequired.getText(), "Required");
		fluentWait.until(ExpectedConditions.elementToBeClickable(forgotpasswordUsernameField)).click();
		//forgotpasswordUsernameField.click();
		forgotpasswordUsernameField.sendKeys("admin");
		fluentWait.until(ExpectedConditions.elementToBeClickable(forgotpasswordResetPassword)).click();
		//forgotpasswordResetPassword.click();
		
		/*
		 * FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
		 * .withTimeout(Duration.ofSeconds(30)) .pollingEvery(Duration.ofSeconds(5))
		 * .ignoring(NoSuchElementException.class);
		 */
		fluentWait.until(ExpectedConditions.visibilityOf(forgotpassSuccess));
		asrt.assertEquals(forgotpassSuccess.getText(),"Reset Password link sent successfully");
	}


	
	
}
