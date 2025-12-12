package FinalProject_AT09.pages;

import keyword.WebUI;
import org.openqa.selenium.By;


public class BasePage {

    private LoginPage loginPage;
    private ClientsPage clientsPage;
    private ProjectsPage projectsPage;
    private TasksPage tasksPage;

    // Elements chung cho tất cả các page

    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuClients = By.xpath("//span[normalize-space()='Clients']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    public By menuTasks = By.xpath("//span[normalize-space()='Tasks']");

    // methods

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public ClientsPage getClientsPage() {
        if (clientsPage == null) {
            clientsPage = new ClientsPage();
        }
        return clientsPage;
    }

    public ProjectsPage getProjectsPage() {
        if (projectsPage == null) {
            projectsPage = new ProjectsPage();
        }
        return projectsPage;
    }

    public TasksPage getTasksPage() {
        if (tasksPage == null) {
            tasksPage = new TasksPage();
        }
        return tasksPage;
    }


    public ClientsPage clickMenuClients() {
        WebUI.clickElement(menuClients);
        return new ClientsPage();
    }


    public ProjectsPage clickMenuProject() {

        WebUI.clickElement(menuProjects);
        return new ProjectsPage();
    }

    public TasksPage clickMenuTasks() {

        WebUI.clickElement(menuTasks);
        return new TasksPage();
    }

}

