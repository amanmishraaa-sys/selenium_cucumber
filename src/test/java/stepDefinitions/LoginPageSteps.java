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

    @Given("Go to the url {string}")
    public void user_is_login_page(String url) {
        loginPage.goToTheLoginPage(url);
    }

    @When("User gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        pageTitle = loginPage.getLoginPageTitle();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String string) {
        Assert.assertEquals(pageTitle, string);
    }

    @And("Verify that forgot password link is displayed")
    public void verifyThatForgotPasswordLinkIsDisplayed(){
        Assert.assertTrue(loginPage.forgotPasswordLinkIsVisible());
    }
    @And("Click on Login button")
    public void clickOnLoginButton(){
        loginPage.clickLoginButton();
    }

    @And("User enters username {string}")
    public void userEntersUsername(String username){
        loginPage.enterUsername(username);
    }

    @And ("User enters password {string}")
    public  void userEntersPassword(String password){
        loginPage.enterPassword(password);
    }
}
