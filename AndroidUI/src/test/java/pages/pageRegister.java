package pages;

import Base.BaseUtil;
import Base.ElementAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class pageRegister extends BaseUtil {
    ElementAction action = new ElementAction();

    public pageRegister(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id = "textInputEditTextName")
    public MobileElement edit_name;
    @AndroidFindBy(id = "textInputEditTextEmail")
    public MobileElement edit_email;

    @AndroidFindBy(id = "textInputEditTextPassword")
    public MobileElement edit_password;

    @AndroidFindBy(id = "textInputEditTextConfirmPassword")
    public MobileElement edit_passwordConfirm;

    @AndroidFindBy(id = "appCompatButtonRegister")
    public MobileElement button_register;

    @AndroidFindBy(id = "textViewLinkLogin")
    public MobileElement button_login;

    @AndroidFindBy(id = "textViewEmail")
    public MobileElement registeredEmail;

    public void fillRegister() throws InterruptedException {
        edit_name.sendKeys("Rafil Dwiyan Akbar");
        edit_email.sendKeys("rafildwiyan@gmail.com");
        edit_password.sendKeys("123rafil123");
        edit_passwordConfirm.sendKeys("123rafil123");
        Thread.sleep(2000);

    }
    public void fillEmailExist() throws InterruptedException {
        edit_name.sendKeys("Rafil Dwiyan Akbar");
        edit_email.sendKeys("rafildwiyan@gmail.com");
        edit_password.sendKeys("123rafil123");
        edit_passwordConfirm.sendKeys("123rafil123");
    }
    public void fillInvalidName() throws InterruptedException {
        edit_name.sendKeys("");
        edit_email.sendKeys("rafildwiyan0gmail.com");
        edit_password.sendKeys("123rafil123");
        edit_passwordConfirm.sendKeys("123rafil123");
    }

    public void clickLogin() throws InterruptedException {
        button_login.click();
    }

    public void clickRegister() throws InterruptedException {
        button_register.click();
    }

    public void notifInvalidName(){
        action.checkTextCountains("Enter Full Name");
    }

    public void notifEmailExist(){
        action.checkTextCountains("Email Already Exists");
    }

    public void registrationSuccess(){
            action.checkTextCountains("Registration Successful");


    }

}
