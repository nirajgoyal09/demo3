package testScript;

import base.BasePage;
import baseTest.DataHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.DataProviders;

import java.util.List;

public class ScrollToView {
    WebDriver driver;

    @BeforeTest
    public void intit(ITestContext context) {
        //nothing for now
        this.driver = BasePage.driverInitializer();
        context.setAttribute("WebDriver", this.driver);
    }

    @AfterTest
    public void quit() {
        driver.close();
        driver.quit();
    }

    @Test(enabled = false)
    public void verifyScrollToView() {
        //access the url
        driver = BasePage.driverInitializer();
        driver.get("https://granddiamonds.artisanssoft.net/fine-jewelry/all-jewels/rings?filtered=1");

        //wait for page to load
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // scroll till the end of the page
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //get the list of rings
        List<WebElement> listOfSearchResult = driver.findElements(By.cssSelector("[class='item--1ENlO']"));
        //  int testResult= driver.findElements(By.cssSelector("[class='item--1ENlO']")).size();


        System.out.println("Ring toatl count is " + listOfSearchResult.size());
        //verify the result count

        // get the target element till you want to scroll
        WebElement elementToScroll = driver.findElement(By.xpath("//div[@title='18K YELLOW GOLD EMERALD SHAPED ILLUSION SET ENGAGEMENT RING']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToScroll);


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test(enabled = false)
    public void verifyAddlist() {
        driver.get("https://granddiamonds.artisanssoft.net/jewelry/199/white-gold-18");
        // add to wish list
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        WebElement cookie = driver.findElement(By.cssSelector("#gdpr-cookie-hide"));

        wait.until(ExpectedConditions.visibilityOf(cookie));
        cookie.click();

        WebElement wishlist = driver.findElement(By.cssSelector(".icon-add_wishlist"));

        wait.until(ExpectedConditions.visibilityOf(wishlist));
        wishlist.click();

        WebElement popupClose = driver.findElement(By.xpath("//div[@id='wishListContinue']//button[@title='Close']"));
        wait.until(ExpectedConditions.visibilityOf(popupClose));
        popupClose.click();


    }


    @Test(enabled = true , description = "login", dataProviderClass = DataHelper.class)
    public void verifyDataProvider(String userName, String pwd) {
        Reporter.log("\nEnter url :" + "https://granddiamonds.artisanssoft.net/");
        driver.get("https://granddiamonds.artisanssoft.net/");
        Reporter.log("click on signup button ");
        driver.findElement(By.cssSelector(".login")).click();
        Reporter.log("Enter user name ");
        driver.findElement(By.cssSelector("#loginEmail")).sendKeys(userName);
        Reporter.log("Enter password ");
        driver.findElement(By.cssSelector("#loginPassword")).sendKeys(pwd);
        Assert.assertEquals("testng", "java");
        Reporter.log("click on login button ");
        driver.findElement(By.cssSelector("#ContinueLoginBtn")).click();

    }

   /* @Test(*//*dataProvider = "excel", dataProviderClass = DataProviders.class*//*)
    public void verifyDataProviderExcel(String username, String password) {
        Reporter.log("\nEnter url :" + "https://granddiamonds.artisanssoft.net/");
        driver.get("https://granddiamonds.artisanssoft.net/");
        Reporter.log("click on signup button ");
        driver.findElement(By.cssSelector(".login")).click();
        Reporter.log("Enter user name ");
        driver.findElement(By.cssSelector("#loginEmail")).sendKeys(username);
        Reporter.log("Enter password ");
        driver.findElement(By.cssSelector("#loginPassword")).sendKeys(password);
        Assert.assertEquals("testng", "java");
        Reporter.log("click on login button ");
        driver.findElement(By.cssSelector("#ContinueLoginBtn")).click();

    }*/


}
