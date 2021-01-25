package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utility.Log;

public class FitnessCalcuatorCopy {
    public WebDriver driver;
    //By fitnesscalc = By.linkText("Fitness & Health Calculators");
    @FindBy(how = How.LINK_TEXT, using = "Fitness & Health Calculators")
    WebElement fitnesscalc;
    //   By bmi_calculator = By.linkText("BMI Calculator");
    @FindBy(how = How.LINK_TEXT, using = "BMI Calculator")
    WebElement bmi_calculator;
    // By us = By.linkText("US Units");
    @FindBy(linkText = "US Units")
    WebElement us;
    //By clear = By.className("clearbtn");
    @FindBy(className = "clearbtn")
    WebElement clear;
    // By age = By.id("cage");
    @FindBy(id = "cage")
    WebElement age;
    //By height = By.id("cheightfeet");
    @FindBy(id = "cheightfeet")
    WebElement height;
    //By height1 = By.id("cheightinch");
    @FindBy(id = "cheightinch")
    WebElement height1;
    //By weight = By.id("cpound");
    @FindBy(id = "cpound")
    WebElement weight;
    //By calculate = By.xpath("//input[@value='Calculate']");
    @FindBy(xpath = "//input[@value='Calculate']")
    WebElement calculate;
    //By result=By.xpath("//div[@class='rightresult']");
    @FindBy(xpath = "//div[@class='rightresult']")
    WebElement result;
    public FitnessCalcuatorCopy(WebDriver dri) {
        this.driver = dri;
        PageFactory.initElements(dri, this);
    }

    public void clickFitnessCalculator() {
        Log.info("Click on fitness calculator");
        fitnesscalc.click();
    }

    public void clickbmi_calculator() {
        Log.info("Click on bmi calculator");
        bmi_calculator.click();
    }

    public void clickUsUnits() {
        Log.info("Click on US UNITS ");
        us.click();
    }

    public void clearButton() {
        Log.info("Click on Clear Button");
        clear.click();
    }

    public void enterAge(String ag) {
        Log.info("Enter Age" + ag);
        age.sendKeys(ag);
    }

    public void enterHeightfeet(String h) {
        Log.info("Enter Height in feet " + h);
        height.sendKeys(h);
    }

    public void enterHeight1(String heigh1) {
        Log.info("Enter Height in inches" + heigh1);

        height1.sendKeys(heigh1);
    }

    public void enterWeight(String weigh) {
        Log.info("Enter Weight" + weigh);

        weight.sendKeys(weigh);
    }

    public void calculateButton() {
        Log.info("Click on Calculate Button");

        calculate.click();
    }

    public String web_result() {
        Log.info("Return Calculated Result");

        return result.getText();
        //    WebElement result1=driver.findElement(result);
        // return result1.getText();
    }
}

