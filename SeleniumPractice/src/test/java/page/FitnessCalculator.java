package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FitnessCalculator {
    public WebDriver driver;
    By fitnesscalc = By.linkText("Fitness & Health Calculators");
    By bmi_calculator = By.linkText("BMI Calculator");
    By us = By.linkText("US Units");
    By clear = By.className("clearbtn");
    By age = By.id("cage");
    By height = By.id("cheightfeet");
    By height1 = By.id("cheightinch");
    By weight = By.id("cpound");
    By calculate = By.xpath("//input[@value='Calculate']");
    By result = By.xpath("//div[@class='rightresult']");
    public FitnessCalculator(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFitnessCalculator() {
        driver.findElement(fitnesscalc).click();
    }

    public void clickbmi_calculator() {
        driver.findElement(bmi_calculator).click();
    }

    public void clickUsUnits() {
        driver.findElement(us).click();
    }

    public void clearButton() {
        driver.findElement(clear).click();
    }

    public void enterAge(String ag) {
        driver.findElement(age).sendKeys(ag);
    }

    public void enterHeightfeet(String h) {
        driver.findElement(height).sendKeys(h);
    }

    public void enterHeight1(String heigh1) {
        driver.findElement(height1).sendKeys(heigh1);
    }

    public void enterWeight(String weigh) {
        driver.findElement(weight).sendKeys(weigh);
    }

    public void calculateButton() {
        driver.findElement(calculate).click();
    }

    public String web_result() {
        return driver.findElement(result).getText();
        //    WebElement result1=driver.findElement(result);
        // return result1.getText();
    }
}

