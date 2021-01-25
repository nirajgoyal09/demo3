package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;


public class CustomLister implements ITestListener, ISuiteListener {

    WebDriver driver;
    String filePath = System.getProperty("user.dir") + "\\reports";


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("==========Executing TestCase - " + result.getMethod().getMethodName());
        Reporter.log("==========Executing TestCase - " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("%%%%%%%%%%%%%%%%%Test Case Failed - " + result.getMethod().getMethodName());

        //Take screen shot

        System.out.println("*****%%%% Error " + result.getName() + " test has failed *****");
        String methodName = result.getName().toString().trim();
        ITestContext context = result.getTestContext();
        // String jc= context.getAttribute("abc").toString();
        //System.out.println("context variiable abc is"+ jc);
        driver = (WebDriver) context.getAttribute("WebDriver");
        //driver=BasePage.driverInitializer();

        takeScreenShot(methodName, driver, result);
    }


    public void takeScreenShot(String methodName, WebDriver driver, ITestResult result) {
        //Screenshot captured and saved in the srcfile object .
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


        try {
            /*FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
            System.out.println("***Placed screen shot in "+filePath+" ***");*/

            String fileName = methodName + ".png";

            String outputDir = result.getTestContext().getOutputDirectory();

            outputDir = outputDir.substring(0, outputDir.lastIndexOf(File.separator)) + "/html";

            final File saved = new File(outputDir, fileName);

            FileUtils.copyFile(scrFile, saved);
            //Reporter.log("<a href=\"" + fileName + "\" target=\"_blank\"><b>Screenshot</b></a><br>");
            Reporter.log("<a href='" + saved.getAbsolutePath() + "'> <img src='" + saved.getAbsolutePath() + "' height='100' width='100'/> </a>");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    @Override
    public void onStart(ISuite suite) {

        System.out.println(" ******************Suite stated  - " + suite.getName());
        Reporter.log(" ******************Suite stated  - " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        Reporter.log(" ******************Suite closed  - " + suite.getName());
        System.out.println("******************Suite closed - " + suite.getName());

    }
}
