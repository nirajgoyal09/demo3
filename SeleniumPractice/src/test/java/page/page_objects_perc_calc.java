package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class page_objects_perc_calc {
    private static WebElement element = null;

    // Math Calc Link
    public static WebElement lnk_math_calc(WebDriver driver) {
        element =
                driver.findElement(By.linkText("Math Calculators"));
        return element;
    }

    // Percentage Calc Link
    public static WebElement lnk_percent_calc(WebDriver driver) {
        element =
                driver.findElement(By.linkText("Percentage Calculator"));
        return element;
    }

    // Number 1 Text Box
    public static WebElement txt_num_1(WebDriver driver) {
        element = driver.findElement(By.id("cpar1"));
        return element;
    }

    // Number 2 Text Box
    public static WebElement txt_num_2(WebDriver driver) {
        element = driver.findElement(By.id("cpar2"));
        return element;
    }

    // Calculate Button
    public static WebElement btn_calc(WebDriver driver) {
        String input;
        element =
                driver.findElement(By.xpath("//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]"));

        return element;
    }

    // Result
    public static WebElement web_result(WebDriver driver) {
        element =
                driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]"));
        return element;
    }

    public static void enterValueIntxt_num_1(WebDriver driver, String value) {
        txt_num_1(driver).clear();
        txt_num_1(driver).sendKeys(value);

    }

    public static void enterValueIntxt_num_2(WebDriver driver, String value) {
        txt_num_2(driver).clear();
        txt_num_2(driver).sendKeys(value);

    }
}



