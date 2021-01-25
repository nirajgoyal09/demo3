package utility;

import org.testng.annotations.DataProvider;

public class DataProviders {


    @DataProvider(name = "excel")

    public Object[][] Authentication() throws Exception{

        Object[][] testObjArray = ExcelUtils.getTableArray(System.getProperty("user.dir")+"\\src\\test\\data\\testdata.xlsx","Sheet1");

        return (testObjArray);

    }
}
