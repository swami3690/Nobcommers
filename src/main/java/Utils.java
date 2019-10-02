import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils extends BasePage {

    //Random Date generator
    public static String randomDate() {
        DateFormat format = new SimpleDateFormat("ddmmyyHummss");
        return format.format(new Date());

    }

    //To get Attribute
    public static String getAttributeValue(By by, String text) {
        return driver.findElement(by).getAttribute(text);
    }

    //To get Css Value
    public static String getCssValue(By by, String value) {
        return driver.findElement(by).getCssValue(value);
    }

    // To wait
    public static void sleep(final long millis, By by) {
        System.out.println((String.format("sleeping %d ms", millis)));
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    // To extract text from element
    public String extractText(By by) {
        String text = driver.findElement(by).getText();
        return text;
    }


    public void randgenerate() {

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
    }

    public static void enterText(By by, String text){


        driver.findElement(by).sendKeys(text);

    }
    public void waitForClickable(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    public void waitForElementVisible(By by, long time) {

        WebDriverWait wait = new WebDriverWait(driver, time);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

    }

    public void waitForAlertPresent(long time) {

        WebDriverWait wait = new WebDriverWait(driver, time);

        wait.until(ExpectedConditions.alertIsPresent());


    }
    public void waitForElementToBeInvisible(By by,int time){

        WebDriverWait  wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));


    }



    public void AssertByText(By by, String expectedResult, String Error){

        Assert.assertEquals(driver.findElement(by).getText(),expectedResult,Error);

    }
    public void clickElement(By by) {

        driver.findElement(by).click();

    }
    public String getText(By by, String text) {

        text = driver.findElement(by).getText();

        return text;
    }



}
