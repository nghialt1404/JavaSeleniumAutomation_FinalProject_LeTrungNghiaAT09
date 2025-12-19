package FinalProject_AT09.testcases;

import FinalProject_AT09.pages.ClientsPage;
import FinalProject_AT09.pages.ProjectsPage;
import common.BaseTest;
import FinalProject_AT09.pages.LoginPage;
import constants.DataConfig;
import helpers.ExcelHelper;
import helpers.PropertiesHelper;
import helpers.SystemHelper;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test
    public void testAddNewProjectForClient() {
        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile(DataConfig.EXCEL_DATA_FILE_PATH, "Login");

        getLoginPage().loginSusscess(excel.getCellData("email", 1), excel.getCellData("password", 1));
        getClientsPage().AddNewClient(DataConfig.COMPANY_NAME);
        getProjectsPage().addNewProject(DataConfig.PROJECT_NAME,DataConfig.COMPANY_NAME);
        getProjectsPage().verifyAddNewProjectForClientSuccess(DataConfig.PROJECT_NAME);
    }
}