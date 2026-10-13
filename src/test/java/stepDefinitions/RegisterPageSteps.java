package stepDefinitions;

import com.factory.DriverFactory;
import com.pages.BasePage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {

    WebDriver driver = DriverFactory.getDriver();

    private BasePage basePage = new BasePage(driver);

    @And("Fill {string} field with {string}")
    public void fill_field_with(String fieldName, String text){
        basePage.registerPage().fillFieldWithText(fieldName,text);
    }

    @And("Select {string} in occupation field")
    public void selectInField(String textToBeSelected) {
        basePage.registerPage().selectFieldWithText(textToBeSelected);
    }

    @And("Click on {string} for gender radio button")
    public void clickOnForGenderRadioButton(String optionName) {
        basePage.registerPage().clickOptionOnRadioButton(optionName);
    }

    @And("{string} the {string} field")
    public void checkTheCheckboxField(String checkOrUncheck, String fieldName) {
        basePage.registerPage().checkTheCheckbox(checkOrUncheck,fieldName);
    }

    @And("Click on {string} button")
    public void clickOnButton(String buttonName) {
        basePage.registerPage().clickTheButton(buttonName);
    }

    @And("Verify the visibility of {string} heading")
    public void verifyTheVisibilityOfHeading(String headingName) {
        Assert.assertTrue(basePage.registerPage().visibilityOfHeading(headingName));
    }

    @And("Fill first name, last name, useremail and usermobile with randoms")
    public void fillFirstNameLastNameUseremailAndUsermobileWithRandoms() {
        basePage.registerPage().fillFirstNameLastNameUseremailAndUsermobileWithRelevantRandoms();
    }

    @And("Verify the visibility of {string} toast message")
    public void verifyTheVisibilityOfToastMessage(String messageText) {
        Assert.assertTrue(basePage.commonPage().verifyToastMessage(messageText));
    }
}
