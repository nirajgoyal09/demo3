import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElements {
    WebDriver driver;

    @BeforeTest // these are annotations of testng
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "D://SeleniumPractice//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("i am in before test");
    }// checkbox
// getattribute, gettagname, getcssvalue,
// get radio button by driver.findelements

    @Test(enabled = false)
    public void findElementPractice() {
        driver.get("https://www.testandquiz.com/selenium/testing.html");
        WebElement textBox = driver.findElement(By.id("fname"));
        textBox.sendKeys("Neeraj Goyal");
        //idOfButton
        WebElement button = driver.findElement(By.id("idOfButton"));
        button.click();
        // female
        WebElement female_radiobutton = driver.findElement(By.id("female"));
        //female_radiobutton.click();
        WebElement male_radiobutton = driver.findElement(By.id("male"));
        boolean j;
        j = female_radiobutton.isSelected();
        System.out.println("Female is selected" + j);

        male_radiobutton.click();
        j = male_radiobutton.isSelected();
        System.out.println("Male is selected" + j);
        WebElement checkBox = driver.findElement(By.className("Automation"));
        checkBox.click();

    }

    @Test
    public void verifyLogin() throws InterruptedException {
        driver.get("http://dbankdemo.com/login");
        WebElement userName, password, signIn, error, firstName, lastName, gender, dob, ssn, sup, sucp, next, email;
        userName = driver.findElement(By.name("username"));
        password = driver.findElement(By.name("password"));
        signIn = driver.findElement(By.id("submit"));
        userName.sendKeys("Test0001");
        //userName= driver.findElement(By.name("username"));
        // userName.clear();
        // boolean status =userName.isDisplayed();
        password.sendKeys("abcd");

        signIn.click();
        error = driver.findElement(By.cssSelector(".sufee-alert.alert.with-close.alert-danger.alert-dismissible.fade.show"));
        boolean s;
        s = error.isDisplayed();
        System.out.println("s is visible" + s);

        // Thread.sleep(1000);

        String errormessage;

        errormessage = error.getText();
        System.out.println(errormessage);
        WebElement signUp = By.xpath("//a[@href='/signup']").findElement(driver);
        signUp.click();
        Select title = new Select(driver.findElement(By.id("title")));

        //title.selectByVisibleText("Mr.");
        //title.selectByValue("Mr.");
        title.selectByIndex(1);
// driver.findElement(By.xpath("//"))
        //badge badge-pill badge-danger
        firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Abcd");
        lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Xyz");
        gender = driver.findElement(By.xpath("//input[@value='M']"));
        gender.click();
        dob = driver.findElement(By.name("dob"));
        dob.sendKeys("20/09/2020");
        ssn = driver.findElement(By.id("ssn"));
        ssn.sendKeys("123-45-6789");
        email = driver.findElement(By.id("emailAddress"));
        email.sendKeys("a@a.com");
        sup = driver.findElement(By.id("password"));
        sup.sendKeys("ightyunbbvcdd");
        sucp = driver.findElement(By.id("confirmPassword"));
        sucp.sendKeys("ightyunbbvcdd");
        next = By.xpath("//button[@type='submit']").findElement(driver);
        next.click();
        driver.close();

    }
    // 1. Clear, driver.pagesource. isEnabled, gettagname, getcssvalue, getattribute, getsize
    // todo- is Displayed. isSelected
}
