package stepDefinitions;
import com.factory.DriverFactory;
import com.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps {

    WebDriver driver = DriverFactory.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    String pageTitle;

    @Given("user is login page")
    public void user_is_login_page() {
        loginPage.goToTheLoginPage();
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        pageTitle = loginPage.getLoginPageTitle();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String string) {
        Assert.assertEquals(pageTitle, string);
    }
}
