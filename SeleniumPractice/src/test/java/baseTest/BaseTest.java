package baseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    /*  BaseTest(){

      }*/
    public WebDriver driver;

    @BeforeTest
    public void Method2() {
        System.out.println("I m in Before Base Test");
      /*System.setProperty("webdriver.chrome.driver", "D://Autoamtion_training_mattarial//SeleniumPractice//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
*/
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
