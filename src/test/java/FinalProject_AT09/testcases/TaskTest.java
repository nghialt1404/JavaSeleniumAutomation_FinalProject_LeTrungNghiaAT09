package FinalProject_AT09.testcases;

import common.BaseTest;
import constants.DataConfig;
import helpers.ExcelHelper;
import org.testng.annotations.Test;

public class TaskTest extends BaseTest {


        @Test
        public void testAddNewTaskForProject() {
            ExcelHelper excel = new ExcelHelper();
            excel.setExcelFile(DataConfig.EXCEL_DATA_FILE_PATH, "Login");

            getLoginPage().loginSusscess(excel.getCellData("email", 1), excel.getCellData("password", 1));
            getClientsPage().AddNewClient(DataConfig.COMPANY_NAME);
            getProjectsPage().addNewProject(DataConfig.PROJECT_NAME,DataConfig.COMPANY_NAME);
            getTasksPage().addNewTask(DataConfig.PROJECT_NAME);
            getTasksPage().verifyAddNewTaskForProjectSuccess(DataConfig.PROJECT_NAME,DataConfig.TASK_NAME);
        }
    }
