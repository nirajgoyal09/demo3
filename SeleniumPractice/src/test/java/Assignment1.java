import baseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class Assignment1 extends BaseTest {

    @Test(enabled = false, description = "First Test Case", priority = 1, invocationCount = 2)
    public void errorEg() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).submit();

        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        //   Assert.assertEquals(alertMessage,"Do you really want to delete this Customer?1");
        //  Assert.assertEquals(alertMessage,"Do you really want to delete this Customer?1","String does not match");
        SoftAssert assert1 = new SoftAssert();
        assert1.assertEquals(alertMessage, "Do you really want to delete this Customer?1");
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }

    @Test(enabled = false, priority = 2)
    public void method1() {
        System.out.println("I m executing after error");
    }

    // get all links
    @Test(enabled = true)
    public void verifyAllLinks() {

        driver.navigate().to("http://demo.guru99.com/test/delete_customer.php");

        List<WebElement> links =
                driver.findElements(By.tagName("a"));
        System.out.println("Number of Links in the Page is " + links.size());
        for (int i = 1; i < links.size(); i = i + 1)
            System.out.println("Name of Link# " + i + links.get(i).getText());
    }
}
