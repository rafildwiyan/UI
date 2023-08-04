package steps;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.pageLogin;

public class stepLogin extends BaseUtil {
    pageLogin pLogin=new pageLogin(driver);
    @Given("I Open the login page")
    public void iOpenTheLoginPage() throws InterruptedException{
    }

    @And("I fill with valid data")
    public void iFillWithValidData() throws InterruptedException {
        pLogin.fillLogin();
    }

    @Then("Click login button")
    public void clickLoginButton() throws InterruptedException{
        pLogin.clickLogin();
    }

    @And("Verify login is success")
    public void verifyLoginIsSuccess() throws InterruptedException{
        pLogin.compareEmailLoggedIn();
    }

    @And("I fill with invalid email")
    public void iFillWithInvalidEmail() throws InterruptedException{
        pLogin.fillInvalidEmail();
    }

    @And("Verify there is a notification on email form")
    public void verifyThereIsANotificationOnEmailForm() {
        pLogin.notifWrongEmail();
    }

    @And("I fill with invalid password")
    public void iFillWithInvalidPassword() throws InterruptedException{
        pLogin.fillInvalidPassword();
    }

    @And("Verify there is a notification toast")
    public void verifyThereIsANotificationToast() {
        pLogin.notifWrongPassword();

    }
}
