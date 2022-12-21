package parallel;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.LoginPage;
import com.qa.factory.DataFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private static String actualTitle;
	private LoginPage loginPage = new LoginPage(DataFactory.getDriver());
	private DataFactory datafactory;
	private WebDriver driver;
	Properties prop;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		
		
		DataFactory.getDriver().get("https://practice.automationtesting.in/my-account/");
		
//		String URL =	prop.getProperty("url");
//		datafactory = new DataFactory();
//		driver = datafactory.init_driver(URL);
		
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		
		actualTitle = loginPage.getLoginTitle();
		System.out.println("Actual Title is :"+actualTitle);
		
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String ExpectedTitle) {
	   
		Assert.assertTrue(actualTitle.contains(ExpectedTitle));
		
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {

	Assert.assertTrue(loginPage.isForgotPasswordLinkExit());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	    
		loginPage.enterUserName(username);
		
	}

	@When("user enters password {string}")
	public void user_enters_password(String userPassword) {
	   
		loginPage.enterUserPassword(userPassword);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	   
		loginPage.clickLoginBtn();
		
	}

	@Then("user gets the title of the home page")
	public void user_gets_the_title_of_Home_the_page() {
	   
		
	}
	
}
