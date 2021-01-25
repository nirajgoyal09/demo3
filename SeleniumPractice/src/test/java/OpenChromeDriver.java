import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class OpenChromeDriver {
    WebDriver driver;

    @BeforeClass
    public void executeBeforeClass() {
        System.out.println("I am In before Class");
    }

    @BeforeMethod
    public void executeBeforeMethod() {
        System.out.println("I am In before Method");
    }

    @BeforeSuite
    public void executeBeforeSuite() {
        System.out.println("I am In before Suite");
    }

    @BeforeTest // these are annotations of testng
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "D://SeleniumPractice//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("i am in before test");
    }

    @Test(enabled = false)
    public void test() {
        this.driver.get("https://www.google.com");
        System.out.println("i am in test");
        System.out.println("Page Title is " + driver.getTitle());
        System.out.println("Page Current URL is " + driver.getCurrentUrl());

    }
    // 1. Maximize driver
    //2. Navigate to back, navigate to forward, Referesh

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://www.javatpoint.com");
        Thread.sleep(5000);
        driver.navigate().to("https://javatpoint.com/selenium-tutorial");
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().forward();
        Thread.sleep(5000);
        driver.navigate().refresh();
    }
    /*@Test
    public void test1(){
        this.driver.get("https://www.google.com");
        System.out.println("i am in test1");
    }*/

    @AfterClass
    public void executeAfterClass() {
        System.out.println("I am In after Class");
    }

    @AfterMethod
    public void execteAfterMethod() {
        System.out.println("I am In After Method");
    }

    @AfterTest
    public void tearDown() {
        /*driver.quit();*/
        driver.close();
        System.out.println("i am in after test");
    }

    @AfterSuite
    public void executeAfterSuite() {
        System.out.println("I am In After Suite");
    }
}
