package stepDefinition;

import static org.junit.Assert.assertTrue;


import com.pages.LogInPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInPageStepsTest {

	// Note- even before below, hooks will get invoked which will call configReader
	// init_prop and
	// DriverFactory init_driver
	private LogInPage login = new LogInPage(DriverFactory.getDriver());
	private static String title;

	@Given("User is on login page")
	public void user_is_on_login_page() {

		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {

		title = login.getLoginPageTitle();
		System.out.println("My page title is  :" + title);

	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {

		assertTrue(title.contains(expectedTitle));

	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {

		assertTrue(login.isForgotPwdLinkExist());

	}

	@When("user enters username {string}")
	public void user_enters_username(String userName) {

		login.enterUserName(userName);

	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {

		login.enterPassword(password);

	}

	@When("user clicks on Sign in Button")
	public void user_clicks_on_sign_in_button() {

		login.clickOnLogin();

	}

}
