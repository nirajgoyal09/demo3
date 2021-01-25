import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPage1 {
    WebDriver driver;

    @BeforeTest // these are annotations of testng
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "D://SeleniumPractice//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("i am in before test");
    }

    // Verify if username is not entered and passwword entered-->click login--> it shows error
    @Test(enabled = false)
    public void loginPageInspectionUsername() {
        driver.get("http://67.211.213.178/PayslipAppTesting/login");
        WebElement username, password, login, error;
        username = driver.findElement(By.cssSelector("input[placeholder='Enter Username']"));
        password = driver.findElement(By.cssSelector("input[placeholder='Enter Password']"));
        password.sendKeys("Test1234");
        login = driver.findElement(By.cssSelector("button[type='submit']"));
        login.click();
        error = driver.findElement(By.cssSelector(".text-danger"));
        error.getText();
        System.out.println("Username is required" + " " + error.getText());
    }

    // Verify if password is not entered and username entered-->click login--> it shows error
    @Test(enabled = false)
    public void loginPageInspectionPassword() {
        driver.get("http://67.211.213.178/PayslipAppTesting/login");
        WebElement username, password, login, error1;
        username = driver.findElement(By.cssSelector("input[placeholder='Enter Username']"));
        username.sendKeys("Test0001");
        password = driver.findElement(By.cssSelector("input[placeholder='Enter Password']"));
        login = driver.findElement(By.cssSelector("button[type='submit']"));
        login.click();
        error1 = driver.findElement(By.cssSelector(".text-danger"));
        error1.getText();
        System.out.println(error1.getText());
    }

    @Test(enabled = true)
    public void loginPageInspectionPopUpError() {
        //  WebDriverWait wait1= new WebDriverWait(driver,20);
        //wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.Toastify__toast-body")));

        driver.get("http://67.211.213.178/PayslipAppTesting/login");
        WebElement username, password, login, popUpError;
        username = driver.findElement(By.cssSelector("input[placeholder='Enter Username']"));
        username.sendKeys("Test0001");
        password = driver.findElement(By.cssSelector("input[placeholder='Enter Password']"));
        password.sendKeys("Test456");
        login = driver.findElement(By.cssSelector("button[type='submit']"));
        login.click();
        //wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.Toastify__toast-body")));

        popUpError = driver.findElement(By.cssSelector("div.Toastify__toast-body"));
        popUpError.getText();
        System.out.println("PopUPError is displayed" + " " + popUpError.getText());


    }

    //3. try successful login
    @Test(enabled = false)
    public void loginPageInspectionSuccesful() throws InterruptedException {
        driver.get("http://67.211.213.178/PayslipAppTesting/login");
        WebElement username, password, login, error2, logout;
        username = driver.findElement(By.cssSelector("input[placeholder='Enter Username']"));
        username.sendKeys("Test0001");
        password = driver.findElement(By.cssSelector("input[placeholder='Enter Password']"));
        password.sendKeys("Test1234");
        login = driver.findElement(By.cssSelector("button[type='submit']"));
        login.click();
        //4. logout
        Thread.sleep(5000);
        logout = driver.findElement(By.cssSelector("i.mdi.mdi-lock"));
        logout.click();
    }
}
