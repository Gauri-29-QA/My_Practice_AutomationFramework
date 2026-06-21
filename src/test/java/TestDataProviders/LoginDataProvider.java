package TestDataProviders;

import org.testng.annotations.DataProvider;
import utilities.ExcelReaderUtils;

public class LoginDataProvider {

    @DataProvider(name="loginData")
    public Object[][] getLoginData(){
    return ExcelReaderUtils.getExcelData("src/test/java/TestDataFiles/LoginData.xlsx","LoginData");
    }


}
