package stepDefinitions;
import com.factory.DriverFactory;
import com.pages.BasePage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps {

    WebDriver driver = DriverFactory.getDriver();

    private BasePage basePage = new BasePage(driver);

    String pageTitle;

    @Given("Go to the url {string}")
    public void user_is_login_page(String url) {
        basePage.loginPage().goToTheLoginPage(url);
    }

    @When("User gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        pageTitle = basePage.loginPage().getLoginPageTitle();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String string) {
        Assert.assertEquals(pageTitle, string);
    }

    @And("Verify that forgot password link is displayed")
    public void verifyThatForgotPasswordLinkIsDisplayed(){
        Assert.assertTrue(basePage.loginPage().forgotPasswordLinkIsVisible());
    }
    @And("Click on Login button")
    public void clickOnLoginButton(){
        basePage.loginPage().clickLoginButton();
    }

    @And("User enters username {string}")
    public void userEntersUsername(String username){
        basePage.loginPage().enterUsername(username);
    }

    @And ("User enters password {string}")
    public  void userEntersPassword(String password){
        basePage.loginPage().enterPassword(password);
    }

    @And("Click on {string} link")
    public void clickOnLink(String linkText) {
        basePage.loginPage().clickOnRegisterHereLink(linkText);
    }
}
