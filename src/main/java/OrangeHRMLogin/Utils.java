package OrangeHRMLogin;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage {
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //enter text on input field
    public void enterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }


    public static String UniqueNumberDateFormate() {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
        Date currDate = new Date();
        return sdf.format(currDate);
    }
    public String findText(By by){
        String text =driver.findElement(by).getText();
        return text;
    }
    public void assertInCorrectURL(String text) {
        Assert.assertTrue(driver.getCurrentUrl().contains(text), "Incorrect URL");
    }
    public void assertURL(String text){
        Assert.assertEquals(driver.getCurrentUrl(),text);

    }



}