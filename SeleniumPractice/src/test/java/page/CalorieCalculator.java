package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalorieCalculator {
    public WebDriver driver;
    @FindBy(linkText = "Fitness & Health Calculators")
    WebElement fitnesscalc2;
    @FindBy(linkText = "Calorie Calculator")
    WebElement cal_calc;
    @FindBy(linkText = "Metric Units")
    WebElement metric;
    @FindBy(xpath = "//img[@class='clearbtn']")
    WebElement clr;
    @FindBy(xpath = "//input[@name='cage']")
    WebElement age;
    @FindBy(xpath = "//label[@for='csex2']")
    WebElement gender;
    @FindBy(xpath = "//input[@name='cheightmeter']")
    WebElement height;
    @FindBy(xpath = "//input[@id='ckg']")
    WebElement weight;
    @FindBy(xpath = "//input[@value='Calculate']")
    WebElement claculate1;
    @FindBy(xpath = "//p[@class='verybigtext']")
    WebElement result;
    public CalorieCalculator(WebDriver dri) {
        this.driver = dri;
        PageFactory.initElements(dri, this);
    }

    public void fitness_Calculator1() {
        fitnesscalc2.click();
    }

    public void body() {
        cal_calc.click();
    }

    public void metricunits() {
        metric.click();
    }

    public void clrbutton() {
        clr.click();
    }

    public void gender_selector() {
        gender.click();
    }

    public void enterage(String age1) {
        age.sendKeys(age1);
    }

    public void enterweight(String w) {
        weight.sendKeys(w);
    }

    public void enterheight(String h) {
        height.sendKeys(h);
    }

    public void calculatebutton() {
        claculate1.click();
    }

    public String getresult() {
        return result.getText();
    }
}
