package steps;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.pageLogin;
import pages.pageRegister;

public class stepRegister extends BaseUtil {
    pageLogin pLogin=new pageLogin(driver);
    pageRegister pRegister=new pageRegister(driver);

    @Given("I Open the register page")
    public void iOpenTheRegisterPage() throws InterruptedException{
        Thread.sleep(2000);
        pLogin.clickRegister();
    }

    @And("I fill with all valid data")
    public void iFillWithAllValidData() throws InterruptedException{
        pRegister.fillRegister();
    }

    @Then("Click register button")
    public void clickRegisterButton() throws InterruptedException{
        pRegister.clickRegister();
    }

    @And("Verify register is success")
    public void verifyRegisterIsSuccess() throws InterruptedException{
        pRegister.registrationSuccess();
    }

    @And("Verify there is a toast notification")
    public void verifyThereIsAToastNotification() throws InterruptedException{
        pRegister.notifEmailExist();
    }



    @And("Verify there is a notification on name form")
    public void verifyThereIsANotificationOnNameForm() throws InterruptedException{
        pRegister.notifInvalidName();
    }

    @And("I fill with invalid name")
    public void iFillWithInvalidName() throws InterruptedException{
        pRegister.fillInvalidName();
    }

    @And("I fill with registered email")
    public void iFillWithRegisteredEmail() throws InterruptedException {
        pRegister.fillEmailExist();
    }
}
