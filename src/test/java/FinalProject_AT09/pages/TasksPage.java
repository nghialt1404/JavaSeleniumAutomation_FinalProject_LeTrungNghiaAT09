package FinalProject_AT09.pages;

import keyword.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TasksPage extends BasePage {

    //Khai báo các element của trang Projects
    private By buttonAddTask = By.xpath("//a[@class='btn btn-default'][normalize-space()='Add task']");
    private By inputTitle = By.xpath("//input[@id='title']");
    private By inputDescription = By.xpath("//textarea[@id='description']");

    // dropdown Relate To
    private By dropdowRelateTo = By.xpath("//div[@class=' col-md-9']//span[normalize-space()='-']");
    private By option_Project = By.xpath("//ul[@class='select2-results']/descendant::div[normalize-space()='Project']");

    // dropdown Project
    private By dropdowProject = By.xpath("//div[@class='col-md-9']//span[normalize-space()='Project']");
    private By inputSearhprojectName = By.xpath("//div[@class='select2-search']/descendant::label[normalize-space()='Project']/following-sibling::input");
    private By option_projectName = By.xpath("//ul[@class='select2-results']/descendant::div[normalize-space()='Project']");

    // dropdown Points
    private By dropdowPoints = By.xpath("//div[@class='col-md-9']//span[normalize-space()='1 Point']");
    private By optionPoints = By.xpath("//ul[@class='select2-results']/descendant::div[normalize-space()='5 Points']");

    //dropdown Milestone
    private By dropdownMilestone = By.xpath("//div[@class='col-md-9']//span[normalize-space()='Milestone']");
    private By optionMilestone = By.xpath("//ul[@class='select2-results']/descendant::div[normalize-space()='-']");

    //dropdown Assign To
    private By dropdownAssignTo = By.xpath("//div[@class='col-md-9']//span[normalize-space()='Assign to']");
    private By optionAssignTo = By.xpath("//ul[@class='select2-results']/descendant::div[normalize-space()='Admin Example']");

    //dropdown Collaborators
    private By dropdownCollaborators = By.xpath("//div[@class='col-md-9']//label[normalize-space()='Collaborators']/following-sibling::input");
    private By optionCollaborators = By.xpath("//ul[@class='select2-results']/descendant::div[normalize-space()='Admin Example']");

    //dropdown Status
    private By dropdownStatus = By.xpath("//div[@class='col-md-9']//span[normalize-space()='To do']");
    private By optionStatus = By.xpath("//ul[@class='select2-results']/descendant::div[normalize-space()='To do']");


    //dropdown Priority
    private By dropdownPriority = By.xpath("//div[@class='col-md-9']//span[normalize-space()='Priority']");
    private By optionPriority = By.xpath("//ul[@class='select2-results']/descendant::div[normalize-space()='Critical']");

    private By inputStartDate = By.xpath("//input[@id='start_date']");
    private By startDate = By.xpath("//td[@class='today day']");
    private By buttonNextMonth = By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']");
    private By inputDeadline = By.xpath("//input[@id='deadline']");
    private By deadlineDate = By.xpath("//td[@class='old today day']");


    private By buttonSave_AddTask = By.xpath("//button[@type='submit']");


    private By alertAddTaskSuccess = By.xpath("//div[@class='circle-done ok']");


    // Method

    public void selectTasksDates() {
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


    public void addNewTask(String projectName) {
        clickMenuTasks();
        WebUI.clickElement(buttonAddTask);
        WebUI.setText(inputTitle, "This is Task for Final Project");
        WebUI.setText(inputDescription, "This is Task for Final Project");
        WebUI.clickElement(dropdowRelateTo);
        WebUI.clickElement(option_Project);

        WebUI.clickElement(dropdowProject);
        WebUI.setText(inputSearhprojectName, projectName);
        WebUI.clickElement(By.xpath("//ul[@class='select2-results']/descendant::div[normalize-space()='" + projectName + "']"));

        WebUI.clickElement(dropdowPoints);
        WebUI.clickElement(optionPoints);

        WebUI.clickElement(dropdownMilestone);
        WebUI.clickElement(optionMilestone);

        WebUI.clickElement(dropdownAssignTo);
        WebUI.clickElement(optionAssignTo);

        WebUI.clickElement(dropdownCollaborators);
        WebUI.clickElement(optionCollaborators);

        WebUI.clickElement(dropdownStatus);
        WebUI.clickElement(optionStatus);

        WebUI.clickElement(dropdownPriority);
        WebUI.clickElement(optionPriority);

        selectTasksDates();
        WebUI.clickElement(buttonSave_AddTask);
    }

    public void verifyAddNewTaskForProjectSuccess() {
        WebUI.waitForElementVisible(alertAddTaskSuccess);
        Assert.assertTrue(WebUI.checkElementExist(alertAddTaskSuccess), "Add new Task not success ");

    }

}
