package baseTest;

import org.testng.annotations.DataProvider;

public class DataHelper {


    @DataProvider(name = "login")
    public static Object[][] getDataFromDataprovider() {
        return new Object[][]{
                {"Guru99", "India"},
                {"Krishna", "UK"},
                {"Bhupesh", "USA"}
        };
    }

    @DataProvider(name = "ExcleDataProvider")
    public static Object[][] getDataFromExcelDataprovider() {
        return new Object[][]{
                {"Guru99", "India"},
                {"Krishna", "UK"},
                {"Bhupesh", "USA"}
        };
    }

    @DataProvider(name = "JsonDataProvider")
    public static Object[][] getDataFromJsonDataprovider() {
        return new Object[][]{
                {"Guru99", "India"},
                {"Krishna", "UK"},
                {"Bhupesh", "USA"}
        };
    }






}
