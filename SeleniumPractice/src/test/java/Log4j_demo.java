import baseTest.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Log4j_demo extends BaseTest {
    static final Logger logger =
            LogManager.getLogger(Log4j_demo.class.getName());

    @Test
    public void log4jMethod() {
        DOMConfigurator.configure("log4j2.xml");
        logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
        logger.info("TEST Has Started");
// Launch website
        driver.navigate().to("http://www.calculator.net/");
        logger.info("Open Calc Application");
// Maximize the browser
        driver.manage().window().maximize();
// Click on Math Calculators
        driver.findElement(By.linkText("Math Calculators")).click();
        logger.info("Clicked Math Calculator Link");
// Click on Percent Calculators
        driver.findElement(By.linkText("Percentage Calculator")).click();
        logger.info("Clicked Percent Calculator Link");
// Enter value 10 in the first number of the percent Calculator
        driver.findElement(By.id("cpar1")).sendKeys("10");
        logger.info("Entered Value into First Text Box");
// Enter value 50 in the second number of the percent Calculator
        driver.findElement(By.id("cpar2")).sendKeys("50");
        logger.info("Entered Value into Second Text Box");
// Click Calculate Button
        driver.findElement(By.xpath("//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]")).click();
        logger.info("Click Calculate Button");
// Get the Result Text based on its xpath
        String result =
                driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).getText();
        logger.info("Get Text Value");
// Print a Log In message to the screen
        logger.info(" The Result is " + result);
        if (result.equals("5")) {
            logger.info("The Result is Pass");
        } else {
            logger.error("TEST FAILED. NEEDS INVESTIGATION");
        }
        logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");

    }
}
