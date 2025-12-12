package FinalProject_AT09.testcases;


import common.BaseTest;
import constants.DataConfig;
import helpers.ExcelHelper;
import helpers.PropertiesHelper;
import helpers.SystemHelper;
import org.testng.annotations.Test;


public class ClientsTest extends BaseTest {

    @Test(priority = 1)
    public void testAddNewClient() {

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile(DataConfig.EXCEL_DATA_FILE_PATH, "Login");

        getLoginPage().loginSusscess(excel.getCellData("email", 1), excel.getCellData("password", 1));

        getClientsPage().AddNewClient(DataConfig.COMPANY_NAME);
        getClientsPage().verifyAddNewClientSuccess();
    }

    @Test(priority = 2)
    public void testEditClient() {

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile(DataConfig.EXCEL_DATA_FILE_PATH, "Login");

        getLoginPage().loginSusscess(excel.getCellData("email", 1), excel.getCellData("password", 1));
        getClientsPage().AddNewClient(DataConfig.COMPANY_NAME);
        getClientsPage().editClient(DataConfig.COMPANY_NAME);
        getClientsPage().verifyEditClientSuccess();
    }

    @Test(priority = 3)
    public void testDeleteClient() {

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile(DataConfig.EXCEL_DATA_FILE_PATH, "Login");


        getLoginPage().loginSusscess(excel.getCellData("email", 1), excel.getCellData("password", 1));

        getClientsPage().AddNewClient(DataConfig.COMPANY_NAME);
        getClientsPage().deleteClient(DataConfig.COMPANY_NAME);
        getClientsPage().verifyDeleteClientSuccess(DataConfig.COMPANY_NAME);
    }

    @Test(priority = 4)
    public void testAddContactForClient() {

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile(DataConfig.EXCEL_DATA_FILE_PATH, "Login");

        getLoginPage().loginSusscess(excel.getCellData("email", 1), excel.getCellData("password", 1));

        getClientsPage().AddNewClient(DataConfig.COMPANY_NAME);
        getClientsPage().addContactForClient(DataConfig.COMPANY_NAME);
        getClientsPage().verifyAddContactForClientSuccess(DataConfig.COMPANY_NAME);
    }


}
