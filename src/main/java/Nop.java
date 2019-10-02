import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Nop extends Utils {
    LoadProp props = new LoadProp();


      @BeforeMethod
       public void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\Resource\\chromedriver.exe");

        // open the browser
        driver = new ChromeDriver();
        // maximise the briwser window screen
        driver.manage().window().fullscreen();
        //set implicity wait for driver object
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        //driver.get(props.getProperty("url"));

    }


        @AfterMethod
       public void closeBrowser() {
       driver.quit();
      }

    @Test
    public void userShouldNewOnLineStoreOpen() {

        //click on login
        clickElement(By.xpath("//a[@class=\"ico-login\"]"));
        // enter email
        enterText(By.name("Email"), "testtest1@test.com");
        //password
        enterText(By.xpath("//input[@id=\"Password\"]"), "abcd1234");
        // click on login
        clickElement(By.xpath("//input[@class=\"button-1 login-button\"]"));

        clickElement(By.className("news-title"));
        enterText(By.id("AddNewComment_CommentTitle"), "Hello Test");
        enterText(By.id("AddNewComment_CommentText"), "add comment for test ");


        clickElement(By.xpath("//input[@name=\"add-comment\"]"));

        AssertByText(By.xpath("//div[@class=\"result\"]"), "News comment is successfully added.", "This comment not save");

    }

    @Test
    public void userShouldAddProductCard() {

        // enterText(By.id("small-searchterms"), props.getProperty("FirstName"));
        enterText(By.id("small-searchterms"), "NiKe");
        clickElement(By.xpath("//input[@class=\"button-1 search-box-button\"]"));

        enterText(By.id("small-searchterms"), "Apple");
        clickElement(By.xpath("//input[@class=\"button-1 search-box-button\"]"));


        enterText(By.id("small-searchterms"), "Vachnamrut");
        // clickElement(By.id("q"));
        clickElement(By.xpath("//input[@class=\"button-1 search-box-button\"]"));
        AssertByText(By.xpath("//div[@class=\"no-result\"]"), "No products were found that matched your criteria.", "This comment not save");
    }

    @Test

    public void addProductCompare() throws InterruptedException {

        clickElement(By.xpath("// div[ @class=\"product-grid home-page-product-grid\"]/div[2]/div[2]/div/div[2]/div[3]/div[2]/input[2]"));
        clickElement(By.xpath("//div[@class='bar-notification success']/p/a"));
        driver.navigate().back();
        clickElement(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div[1]/div/div[2]/div[3]/div[2]/input[2]"));
        clickElement(By.xpath("//div[@class='bar-notification success']/p/a"));
        clickElement(By.xpath("//a[@class=\"clear-list\"]"));
        AssertByText(By.xpath("//div[@class=\"no-data\"]"),"You have no items to compare.","Error");

    }


}









