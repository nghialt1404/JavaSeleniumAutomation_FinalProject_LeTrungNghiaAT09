package FinalProject_AT09.testcases;

import FinalProject_AT09.pages.LoginPage;
import common.BaseTest;
import constants.DataConfig;
import helpers.ExcelHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Description("Verify user can login with valid credentials")
    @Test(priority = 1, testName = "Login Success", description = "Verify user can login with valid credentials")
    public void testLoginSuccess() {

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile(DataConfig.EXCEL_DATA_FILE_PATH, "Login");

        getLoginPage().loginSusscess(excel.getCellData("email", 1), excel.getCellData("password", 1));
        getLoginPage().verifyLoginSuccess();

    }

    @Description("Verify user can not login with invalid email")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void testLoginFailWithEmailInvalid() {

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile(DataConfig.EXCEL_DATA_FILE_PATH, "Login");
        getLoginPage().loginFailureWithEmailInvalid(excel.getCellData("email", 2), excel.getCellData("password", 2));
        getLoginPage().verifyLoginFailureWithInvalidEmailOrPassword();
    }

    @Description("Verify user can not login with invalid password")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void testLoginFailWithPasswordInvalid() {

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile(DataConfig.EXCEL_DATA_FILE_PATH, "Login");
        getLoginPage().loginFailureWithPasswordInvalid(excel.getCellData("email", 3), excel.getCellData("password", 3));
        getLoginPage().verifyLoginFailureWithInvalidEmailOrPassword();
    }

    @Description("Verify user can not login with email null")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void testLoginFailWithEmailNull() {

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile(DataConfig.EXCEL_DATA_FILE_PATH, "Login");

        getLoginPage().loginFailureWithEmailNull(excel.getCellData("email", 4), excel.getCellData("password", 4));
        getLoginPage().verifyLoginFailureWithEmailNull();
    }

    @Description("Verify user can not login with password null")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void testLoginFailWithPasswordNull() {

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile(DataConfig.EXCEL_DATA_FILE_PATH, "Login");

        getLoginPage().loginFailureWithPasswordNull(excel.getCellData("email", 5), excel.getCellData("password", 5));
        getLoginPage().verifyLoginFailureWithPasswordNull();
    }

}
