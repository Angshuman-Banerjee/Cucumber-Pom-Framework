package stepDefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccoutPage;
import com.pages.LogInPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageStepsTest {

	private LogInPage login = new LogInPage(DriverFactory.getDriver());
	private AccoutPage accountpage;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {

		List<Map<String, String>> cred = credTable.asMaps();
		String userName = cred.get(0).get("username");
		String passWord = cred.get(0).get("password");
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountpage = login.doLgIn(userName, passWord);
	}

	@Given("User is on Accounts page")
	public void user_is_on_accounts_page() {

		System.out.println(accountpage.getPageTitle());

	}

	@Then("User gets accounts section")
	public void user_gets_accounts_section(io.cucumber.datatable.DataTable sectionTable) {

		List<String> expsectionList = sectionTable.asList();
		List<String> actsectionList = accountpage.getAccountsectionText();

		Assert.assertTrue(expsectionList.containsAll(actsectionList));

	}

	@Then("Account section count should be {int}")
	public void account_section_count_should_be(Integer int1) {

		Assert.assertTrue(accountpage.getAccountsectioncount() == int1);

	}

}
