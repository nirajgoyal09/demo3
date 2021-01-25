import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPage {
    WebDriver driver;

    @BeforeTest // these are annotations of testng
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "D://SeleniumPractice//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("i am in before test");
    }

    // Verify if username is not entered and passwword entered-->click login--> it shows error
    @Test(enabled = false)
    public void loginPageInspectionUsername() {
        driver.get("http://67.211.213.178/PayslipAppTesting/login");
        WebElement username, password, login, error;

        username = driver.findElement(By.xpath("//input[@name='username']"));
        //  username.sendKeys("Test0001");
        password = driver.findElement(By.xpath("//*[contains(@name,'password')]"));
        password.sendKeys("Test1234");

        login = By.xpath("//button[contains(@type,'submit')]").findElement(driver);
        login.click();
        error = driver.findElement(By.xpath("//span[contains(text(),'Username is required')]"));
        error.getText();
        System.out.println("Username is required" + " " + error.getText());

// todo 1. try verify password message
// 2. invalid username and password And catch popup
//3. try successful login
// 4. try logout
    }

    // Verify if password is not entered and username entered-->click login--> it shows error
    @Test(enabled = false)
    public void loginPageInspectionPassword() {
        driver.get("http://67.211.213.178/PayslipAppTesting/login");
        WebElement username, password, login, error1;
        username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Test0001");
        password = driver.findElement(By.xpath("//*[contains(@name,'password')]"));
        login = By.xpath("//button[contains(@type,'submit')]").findElement(driver);
        login.click();
        boolean status = password.isDisplayed();
        System.out.println(status);
        error1 = driver.findElement(By.xpath("//span[contains(text(),'Password is required.')]"));
        error1.getText();
        System.out.println(error1.getText());
    }

    // 2. invalid username and password And catch popup
    @Test(enabled = false)
    public void loginPageInspectionInvalid() {
        driver.get("http://67.211.213.178/PayslipAppTesting/login");
        WebElement username, password, login, error2;
        username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Test");
        password = driver.findElement(By.xpath("//*[contains(@name,'password')]"));
        password.sendKeys("Test12");
        login = By.xpath("//button[contains(@type,'submit')]").findElement(driver);
        login.click();
        boolean status1 = username.isDisplayed();
        boolean status = password.isDisplayed();
        System.out.println(status1 + " " + status);
    /* error2=driver.findElement(By.cssSelector(".Toastify__toast-container.Toastify__toast-container--top-right"));
     boolean a;
     a= error2.isDisplayed();
     System.out.println("a is visible"+ a);*/
    }

    //3. try successful login
    @Test(enabled = true)
    public void loginPageInspectionSuccesful() throws InterruptedException {
        driver.get("http://67.211.213.178/PayslipAppTesting/login");
        WebElement username, password, login, error2, logout;
        username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Test0001");
        password = driver.findElement(By.xpath("//*[contains(@name,'password')]"));
        password.sendKeys("Test1234");
        login = By.xpath("//button[contains(@type,'submit')]").findElement(driver);
        login.click();
        Thread.sleep(5000);
        // 4. try logout
        logout = driver.findElement(By.xpath("//span[contains(text(),'Logout-jp')]"));
        logout.click();
    }
}
