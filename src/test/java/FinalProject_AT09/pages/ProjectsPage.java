package FinalProject_AT09.pages;


import keyword.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProjectsPage extends BasePage {

    //Khai báo các element của trang Projects
    private By buttonAddProject = By.xpath(" //a[@title='Add project']");
    private By inputTitle = By.xpath("//input[@id='title']");

    // dropdown Client
    private By dropdownClient = By.xpath("//div[@class=' col-md-9']//span[normalize-space()='Customer Example']");
    private By inputSearchClient = By.xpath("//input[@id='s2id_autogen7_search']");

    private By inputDescription = By.xpath("//textarea[@id='description']");
    private By inputStartDate = By.xpath("//input[@id='start_date']");
    private By startDate = By.xpath("//td[@class='today day']");
    private By buttonNextMonth = By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']");
    private By inputDeadline = By.xpath("//input[@id='deadline']");
    private By deadlineDate = By.xpath("//td[@class='old today day']");
    private By inputPrice = By.xpath("//input[@id='price']");

    //dropdown Labels
    private By dropdownLabels = By.xpath("//div[@class=' col-md-9']//li[normalize-space()='Labels']");
    private By optionLabels_CICD = By.xpath("//ul[@class='select2-results']/descendant::div[normalize-space()='CI/CD']");
    private By buttonSave_AddProject = By.xpath("//button[@type='submit']");
    private By alertAddProjectSuccess = By.xpath("//div[@class='circle-done ok']");


    // Method

    public void selectProjectDates() {
        // Start date = Today
        WebUI.clickElement(inputStartDate);
        WebUI.clickElement(startDate);

        // Deadline = Today + 30 days
        LocalDate d = LocalDate.now().plusDays(30);
        WebUI.clickElement(inputDeadline);

        // Chuyển đến đúng month-year của deadline
        while (!WebUI.getElementText(By.xpath("//th[@class='datepicker-switch']")).contains(d.format(DateTimeFormatter.ofPattern("MMM")))) {
            WebUI.clickElement(By.xpath("//th[@class='next']"));
        }

        // Click đúng ngày
        WebUI.clickElement(By.xpath("//td[text()='" + d.getDayOfMonth() + "']"));
    }


    public void addNewProject(String projectName, String customerName) {
        clickMenuProject();
        WebUI.clickElement(buttonAddProject);
        WebUI.setText(inputTitle, projectName);
        WebUI.clickElement(dropdownClient);
        WebUI.setText(inputSearchClient, customerName);
        WebUI.clickElement(By.xpath("//ul[@class='select2-results']/descendant::div[normalize-space()='" + customerName + "']"));
        WebUI.setText(inputDescription, "This is description for Project Automation Testing");

        selectProjectDates();

        WebUI.setText(inputPrice, "5000");
        WebUI.clickElement(dropdownLabels);
        WebUI.clickElement(optionLabels_CICD);
        WebUI.clickElement(buttonSave_AddProject);
    }

    public void verifyAddNewProjectForClientSuccess() {
        WebUI.waitForElementVisible(alertAddProjectSuccess);
        Assert.assertTrue(WebUI.checkElementExist(alertAddProjectSuccess), "Add new project not success ");
    }

}


