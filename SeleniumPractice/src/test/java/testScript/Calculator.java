package testScript;

import base.BasePage;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.BodyFatCalculator;
import page.FitnessCalcuatorCopy;
import page.page_objects_perc_calc;
import utility.CSVDataProvider;
import utility.DataProviders;
import utility.Log;

import java.io.IOException;

public class Calculator {


    /*static final Logger logger =
                LogManager.getLogger(Calculator.class.getName());

    */
    WebDriver driver;
    //String abc="Jitendra";

    @BeforeTest
    public void initilize(ITestContext context) {
        //nothing for now
        this.driver = BasePage.driverInitializer();
        context.setAttribute("WebDriver", this.driver);
        //context.setAttribute("abc", abc);
    }

    @AfterTest
    public void quit() {
        driver.close();
        driver.quit();
    }

    @Test(enabled = false, description = "Test Case for % calculator")

    public void percentCalculatorEg() {

        driver.get("http://www.calculator.net");

// Use page Object library now
        //logger.info("Click on Math Link");

        page_objects_perc_calc.lnk_math_calc(driver).click();
        //    logger.info("Click on % Link");
        page_objects_perc_calc.lnk_percent_calc(driver).click();

        page_objects_perc_calc.enterValueIntxt_num_1(driver, "10");
        page_objects_perc_calc.enterValueIntxt_num_2(driver, "50");
        page_objects_perc_calc.btn_calc(driver).click();
        String result =
                page_objects_perc_calc.web_result(driver).getText();
        System.out.println(result);
        // it is applied to fail the condition .... Assert.assertEquals(result,"6");
        Assert.assertEquals(result, "10% of 50 = 5", "Results are incorrect");
        if (result.contains("5")) {
            System.out.println(" The Result is Pass");
        } else {
            System.out.println(" The Result is Fail");
        }
    }

    @Test(enabled = false, description = "Test case for fitness claculator", dependsOnMethods = "percentCalculatorEg")
    public void fitnessCalculator() {
        DOMConfigurator.configure("log4j2.xml");
        Log.startTest("Test Case for fitnessCalculator ");

        driver.get("http://www.calculator.net");
        //  FitnessCalculator b= new FitnessCalculator(driver);
        FitnessCalcuatorCopy b = new FitnessCalcuatorCopy(driver);

        b.clickFitnessCalculator();
        b.clickbmi_calculator();
        b.clickUsUnits();
        b.clearButton();
        b.enterAge("25");
        b.enterHeightfeet("5");
        b.enterHeight1("10");
        b.enterWeight("180");
        b.calculateButton();
        String result = b.web_result();

        System.out.println(result);
        if (result.contains("Overweight")) {
            System.out.println(" The Result is Pass");
        } else {
            System.out.println(" The Result is Fail");
        }
        Log.endTest();
    }

    @Test(enabled = true, description = "Test case for body fat calculator")
    public void bodyFatCalculator() throws InterruptedException, IOException {
        driver.get("http://www.calculator.net");
        BodyFatCalculator a = new BodyFatCalculator(driver);

        a.fitness_Calculator1();
        a.body();
        a.metricunits();
        a.clrbutton();
        Thread.sleep(2000);
        a.gender_selector();
        a.enterage("24");
        a.enterweight("80");
        a.enterheight("195");

     /*   Assertion assertion = new Assertion();
        assertion.assertEquals(false,a.equals(a));*/
        //Assert.assertEquals("testng", "java");
        a.enterneck("50");
        a.enterwaist("96");
        a.enterhip("93");
        a.calculatebutton();
        String result = a.getresult();

        System.out.println(result);
        if (result.contains("Body Fat")) {
            System.out.println(" The Result is Pass");
        } else {
            System.out.println(" The Result is Fail");
        }
    }

    @Parameters("year")//Parameter name
    @Test(priority = 1, description = "get parameter from Test suite Surefire", groups = {"smoke"})
    public void getYear(String year) {
        System.out.println("get parameter from Test suite Surefire-" + year);
    }

    @Test(groups = {"UAT"})
    public void downloadMultipleFiles() {
// Navigate to the URL
        driver.get("https://www.google.com/");
        System.out.println("The title of the Site is " + driver.getCurrentUrl());

    }

    @Parameters({"username", "password"})
    @Test(description = "Get credentials from test plan")
    public void testCaseTwo(String username, String password) {
        System.out.println("Username from Test plan:- " + username);
        System.out.println("Password from Test plans :- " + password);
        //Assert.fail();
    }


    @Test(enabled = false, description="Get credentials from test plan", dataProviderClass = CSVDataProvider.class, dataProvider = "testData")
    public void testCaseThree(String username, String password) {
        System.out.println("Username1 from Test plan:- " + username);
        System.out.println("Password1 from Test plans :- " + password);
        //Assert.fail();
    }

   // @Parameters({"username", "password"})
    @Test(description = "Get credentials from test plan",dataProvider = "excel",dataProviderClass = DataProviders.class)
    public void testCaseExcel(String username, String password) {
        System.out.println("---------Username excel from Test plan:- " + username);
        System.out.println("-----------Password excel from Test plans :- " + password);
        //Assert.fail();
    }
}
