package TestDataProviders;

import org.testng.annotations.DataProvider;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class LoginDataProvider {

    @DataProvider(name="loginData")
    public Object[][] getLoginData(){
    return ExcelReader.getExcelData("src/test/java/TestDataFiles/LoginData.xlsx","LoginData");
    }


}
