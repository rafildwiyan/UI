package Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class ElementAction extends BaseUtil {

    public void hover(MobileElement element) {
        MobileElement elems= element;
        Actions builder = new Actions(driver);
        Actions hoverOverRegistrar = builder.moveToElement(elems);
        hoverOverRegistrar.perform();

    }

    public void androidBack() {

        driver.navigate().back();
    }
    public void openNotification() {

        driver.openNotifications();
    }

    public void checkerEqual(By element, String expected) {
        Assert.assertEquals(driver.findElement(element).getText(), expected);
    }

    public void pressEnter() {
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public boolean checkPageElement(String text) {
        driver.getPageSource().contains(text);
        return true;
    }

    public boolean checkPageSource(String text) {
        driver.getPageSource().contains(text);
        return false;
    }

    public void checkTextCountains(String text) {
        if(driver.getPageSource().contains(text))
        {
            System.out.println("Text found");
        }
        else
        {
            Assert.fail("Text doesn't found");
        }
    }

    public boolean waitUntiElementPresent(By element) {
        try{
            WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(element));
        }
        catch(TimeoutException exception) {
            return false;
        }
        return true;
    }

    public void scrollAndClick(String text) {
        String uiSelector = "new UiSelector().textMatches(\"" + text
                + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + uiSelector + ");";
        driver.findElementByAndroidUIAutomator(command).click();
    }

    public void scroToElement(String text) {
        String uiSelector = "new UiSelector().textMatches(\"" + text
                + "\")";

        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + uiSelector + ");";

        driver.findElementByAndroidUIAutomator(command);
    }

    public void swipeByElements (MobileElement startElement, MobileElement endElement) {
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
        new TouchAction(driver)
                .press(point(startX,startY))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endX, endY))
                .release().perform();
    }




}

