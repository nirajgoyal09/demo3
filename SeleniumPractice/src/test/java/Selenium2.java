import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Selenium2 {
    WebDriver driver;

    @BeforeTest // these are annotations of testng
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "D://SeleniumPractice//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("i am in before test");
    }

    @Test(enabled = false)
    public void loginPagePopUpError() throws InterruptedException {
        //  WebDriverWait wait1= new WebDriverWait(driver,20);
        //wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.Toastify__toast-body"))
        WebElement signUp;
        driver.get("https://www.demoblaze.com/index.html");
        signUp = driver.findElement(By.linkText("Sign up"));
        signUp.click();
        //username
        driver.findElement(By.id("sign-username")).sendKeys("nirajgoyal");
        //password
        driver.findElement(By.id("sign-password")).sendKeys("12345");
        //SignUp button
        driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().getText();
        System.out.println("Alert text is" + " " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    // when there is no password
    @Test(enabled = false)
    public void loginPagePopUpError1() throws InterruptedException {
        WebElement signUp;
        driver.get("https://www.demoblaze.com/index.html");
        signUp = driver.findElement(By.linkText("Sign up"));
        signUp.click();
        //username
        driver.findElement(By.id("sign-username")).sendKeys("nirajgoyal");
        //SignUp button
        driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().getText();
        System.out.println("Alert text is" + " " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    // when there is no username
    @Test(enabled = true)
    public void loginPagePopUpError2() throws InterruptedException {
        WebElement signUp;
        driver.get("https://www.demoblaze.com/index.html");
        signUp = driver.findElement(By.linkText("Sign up"));
        signUp.click();
        //password
        driver.findElement(By.id("sign-password")).sendKeys("12345");
        //SignUp button
        driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().getText();
        System.out.println("Alert text is" + " " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test(enabled = false)
    // handling multiple windows
    public void multipleWindows() throws InterruptedException {
        driver.get("http://demo.guru99.com/popup.php");
        WebElement click1;
        driver.findElement(By.linkText("Click Here")).click();
        String mainWindow = driver.getWindowHandle();
        System.out.println("Guru 99 demo site" + " " + mainWindow);

        Set<String> windowSet = driver.getWindowHandles();
        System.out.println("Guru 99 demo site" + " " + windowSet);
        //  driver.findElement(By.name("emailid")).sendKeys("abc@abcl.com");
//driver.findElement(By.name("btnLogin")).click();
        Iterator<String> i1 = windowSet.iterator();
        while (i1.hasNext()) {
            String childWindow = i1.next();
            System.out.println("ChildWindow" + " " + childWindow);
            if (!mainWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                driver.findElement(By.name("emailid")).sendKeys("abc@abcl.com");
                driver.findElement(By.name("btnLogin")).click();
            }
        }
        driver.switchTo().window(mainWindow);
        Thread.sleep(2000);
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(2000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}