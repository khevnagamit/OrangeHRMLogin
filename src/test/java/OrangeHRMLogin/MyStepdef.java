package OrangeHRMLogin;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MyStepdef extends Utils {
    @When("^user put valid credential \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_put_valid_credential_and(String UserName, String Password)  {
        enterText(By.id("txtUsername"),UserName);
        enterText(By.id("txtPassword"),Password);
    }

    @And("^click submit button$")
    public void click_submit_button(){
        clickOnElement(By.id("btnLogin"));
    }

    @Then("^user should able to register successfully$")
    public void user_should_able_to_register_successfully() {
        assertURL("https://opensource-demo.orangehrmlive.com/index.php/dashboard");

    }

    @When("^user put in valid credential \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userPutInValidCredentialAnd(String InvalidUserName, String InvalidPassword){
        enterText(By.id("txtUsername"),InvalidUserName);
        enterText(By.id("txtPassword"),InvalidPassword);
    }

    @Then("^user should not able to login and should see error message$")
    public void userShouldNotAbleToLoginAndShouldSeeErrorMessage() {
        assertURL("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");

    }
}
