package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    static public Properties prop;
    static public WebDriver driver;

    //retrun the driver
    public static WebDriver driverInitializer() {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
            prop.load(fis);
            System.out.println("user directory is " + System.getProperty("user.dir"));
        } catch (Exception e) {
            System.out.println("propery file not found ");
        }

        System.out.println(prop.getProperty("browser"));
        if (prop.getProperty("browser").equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches",
                    Collections.singletonList("enable-automation"));
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        return driver;

    }


}
