package pages;

import Base.BaseUtil;
import Base.ElementAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class pageLogin extends BaseUtil {

    ElementAction action = new ElementAction();

    public pageLogin(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id = "textInputEditTextEmail")
    public MobileElement edit_email;

    @AndroidFindBy(id = "textInputEditTextPassword")
    public MobileElement edit_password;

    @AndroidFindBy(id = "textViewLinkRegister")
    public MobileElement button_register;

    @AndroidFindBy(id = "appCompatButtonLogin")
    public MobileElement button_login;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.support.v7.widget.LinearLayoutCompat/TextInputLayout[1]/android.widget.LinearLayout/android.widget.TextView")
    public MobileElement notif_email;

    @AndroidFindBy(id = "snackbar_text")
    public MobileElement notif_password;

    @AndroidFindBy(id = "textViewEmail")
    public MobileElement registeredEmail;

    public void fillLogin() throws InterruptedException {
        edit_email.sendKeys("rafildwiyan@gmail.com");
        edit_password.sendKeys("123rafil123");;
    }
    public void fillInvalidEmail() throws InterruptedException {
        edit_email.sendKeys("rafildwiyan0gmail.com");
        edit_password.sendKeys("123password123");;
    }
    public void fillInvalidPassword() throws InterruptedException {
        edit_email.sendKeys("rafildwiyan@gmail.com");
        edit_password.sendKeys("password123");;
    }

    public void clickLogin() throws InterruptedException {
        Thread.sleep(2000);
        button_login.click();
    }

    public void clickRegister() throws InterruptedException {
        button_register.click();
    }

    public void notifWrongEmail(){
        action.checkTextCountains("Enter Valid Email");
    }

    public void notifWrongPassword(){
        action.checkTextCountains("Wrong Email or Password");
    }

    public void compareEmailLoggedIn(){
        Assert.assertEquals(registeredEmail.getText(),"rafildwiyan@gmail.com");
    }

}
