package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    // DataProvider 1
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        // Taking xl file from testData folder
        String path = ".\\testData\\CapacityLoginData.xlsx";

        // Creating an object for ExcelUtility
        ExcelUtility xlutil = new ExcelUtility(path);

        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        // Created two dimensional array which can store login data
        String logindata[][] = new String[totalrows][totalcols];

        // Read the data from xl storing in two dimensional array
        for (int i = 1; i <= totalrows; i++) {     // i is rows
            for (int j = 0; j < totalcols; j++) {  // j is columns
                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }

        return logindata; // returning two dimensional array
    }
}
