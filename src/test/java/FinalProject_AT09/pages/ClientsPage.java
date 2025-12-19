package FinalProject_AT09.pages;

import helpers.SystemHelper;
import keyword.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ClientsPage extends BasePage {

    // Khai báo các element của trang Dashboard
    private By inputSearchClient = By.xpath("//input[@type='search']");
    private By buttonAddClient = By.xpath("//a[normalize-space()='Add client']");
    private By option_Organization = By.xpath("//label[normalize-space()='Organization']");
    private By option_Person = By.xpath("//label[normalize-space()='Person']");
    private By inputcompanyName = By.xpath("//input[@id='company_name']");

    //Dropdown Owner
    private By dropdownOwner = By.xpath("//label[@for='created_by']/following-sibling::div");
    private By inputSearchOwner = By.xpath("//div[@id='select2-drop']//input");
    private By optionOwner_AnhTesterAdmin = By.xpath("//ul[@class='select2-results']//div[normalize-space()='Anh Tester Admin']");


    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZipcode = By.xpath("//input[@id='zip']");
    private By inputCountry = By.xpath("//input[@id='country']");
    private By inputPhone = By.xpath("//input[@id='phone']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By inputVatNumber = By.xpath("//input[@id='vat_number']");
    private By inputGSTNumber = By.xpath("//input[@id='gst_number']");

    // Dropdown ClientGroup
    private By dropdownClientGroup = By.xpath("//div[@class='col-md-9']/descendant::li[@class='select2-search-field']");
    private By optionClientGroup_Vip = By.xpath("//ul[@class='select2-results']//div[normalize-space()='VIP']");

    // Dropdown Labels
    private By dropdownLabels = By.xpath("//div[@class='col-md-9']/descendant::li[normalize-space()='Labels']");
    private By optionLabels_HtestAutomation = By.xpath("//ul[@class='select2-results']//div[normalize-space()='Htest Automation']");

    private By buttonSave = By.xpath("//button[@type='submit']");
    private By buttonSaveAndContinue = By.xpath("//button[@id='save-and-continue-button']");

    private By buttonEditClient = By.xpath("//a[@title='Edit client']");
    private By buttonDeleteClient = By.xpath("//a[@title='Delete client']");
    private By buttonConfirmDelete = By.xpath("//button[@id='confirmDeleteButton']");

    private By alertDeleteClientSuccess = By.xpath("//div[@class='app-alert-message']");
    private By alertAddClientSuccess = By.xpath("//a[normalize-space()='Add client']");
    private By alertEditClientSuccess = By.xpath("//div[@class='circle-done ok']");
    private By alertaddContactSuccess = By.xpath("//div[@class='circle-done ok']");

    private By tabClients = By.xpath("//ul[@id='client-tabs']/descendant::a[normalize-space()='Clients']");
    private By tabContacts = By.xpath("//ul[@id='client-tabs']/descendant::a[normalize-space()='Contacts']");

    // Add contact
    private By buttonAddContact = By.xpath("//a[@title='Add contact']");
    private By inputFirstName = By.xpath("//input[@id='first_name']");
    private By inputLastName = By.xpath("//input[@id='last_name']");
    private By inputContactEmail = By.xpath("//input[@id='email']");
    private By inputContactPhone = By.xpath("//input[@id='phone']");
    private By inputContactSkype = By.xpath("//input[@id='skype']");
    private By inputContactJobtitle = By.xpath("//input[@id='job_title']");
    private By checkboxGenderMale = By.xpath("//div[@class='col-md-9']/descendant::label[normalize-space()='Male']");
    private By inputPassword = By.xpath("//input[@id='login_password']");
    private By checkbokPermission = By.xpath("//input[@id='can_access_everything']");
    private By buttonSaveContact = By.xpath("//button[@type='submit']");
    private By buttonGeneratePassword = By.xpath("//label[@id='generate_password']");

    //Method
    public void clickTabClients() {
        WebUI.clickElement(tabClients);
    }

    public void clickTabContacts() {
        WebUI.clickElement(tabContacts);
    }

    public void AddNewClient(String companyName) {

        clickMenuClients();
        WebUI.clickElement(buttonAddClient);
        WebUI.clickElement(option_Organization);
        WebUI.setText(inputcompanyName, companyName);

        //Dropdown Owner
        WebUI.clickElement(dropdownOwner);
        WebUI.clickElement(optionOwner_AnhTesterAdmin);

        WebUI.setText(inputAddress, "Cong Hoa");
        WebUI.setText(inputCity, "Ho Chi Minh");
        WebUI.setText(inputState, "Ho Chi Minh");
        WebUI.setText(inputZipcode, "700000");
        WebUI.setText(inputCountry, "Viet Nam");
        WebUI.setText(inputPhone, "0923456789");
        WebUI.setText(inputWebsite, "https//anhtester.com");
        WebUI.setText(inputVatNumber, "123456");
        WebUI.setText(inputGSTNumber, "654321");

        WebUI.scrollToElement(dropdownLabels);

        //Dropdown Client Group
        WebUI.clickElement(dropdownClientGroup);
        WebUI.clickElement(optionClientGroup_Vip);

        // Dropdown Labels
        WebUI.clickElement(dropdownLabels);
        WebUI.clickElement(optionLabels_HtestAutomation);

        WebUI.clickElement(buttonSave);
    }

    public void editClient(String companyName) {
        clickTabClients();
        WebUI.setText(inputSearchClient, companyName);
        WebUI.sleep(2);

        WebUI.clickElement(buttonEditClient);
        WebUI.setText(inputCountry, "USA");
        WebUI.setText(inputPhone, "0947385743");
        WebUI.clickElement(buttonSave);

    }

    public void deleteClient(String companyName) {
        clickTabClients();
        WebUI.setText(inputSearchClient, companyName);
        WebUI.sleep(2);

        WebUI.clickElement(buttonDeleteClient);
        WebUI.clickElement(buttonConfirmDelete);
    }

    public void addContactForClient(String companyName) {
        clickTabClients();
        WebUI.setText(inputSearchClient, companyName);
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath("//tbody/tr[1]/td[2]"));
        WebUI.waitForPageLoaded();
        WebUI.clickElement(buttonAddContact);
        WebUI.setText(inputFirstName, "Nghia");
        WebUI.setText(inputLastName, "Le");
        WebUI.setText(inputContactEmail, "anhtester@gmail.com");
        WebUI.setText(inputContactPhone, "0987654321");
        WebUI.setText(inputContactSkype, "anhtester.skype");
        WebUI.setText(inputContactJobtitle, "Tester");
        WebUI.scrollToElement(buttonSaveContact);
        WebUI.clickElement(checkboxGenderMale);
        WebUI.clickElement(buttonGeneratePassword);
        WebUI.clickElement(checkbokPermission);
        WebUI.clickElement(buttonSaveContact);
        WebUI.sleep(1);

    }

    public void verifyAddNewClientSuccess() {
        WebUI.waitForElementVisible(alertAddClientSuccess);
        Assert.assertTrue(WebUI.checkElementExist(alertAddClientSuccess, 5, 1000), "Add New Client not success");
    }

    public void verifyEditClientSuccess() {
        WebUI.waitForElementVisible(alertEditClientSuccess);
        Assert.assertTrue(WebUI.checkElementExist(alertEditClientSuccess), "Edit Client not success");
    }

    public void verifyDeleteClientSuccess(String companyName) {
        WebUI.waitForElementVisible(alertDeleteClientSuccess);
        Assert.assertEquals(WebUI.getElementText(alertDeleteClientSuccess), "The record has been deleted", "Message not match!");

        // Check lại client vừa xoá còn tồn tại hay không
        Assert.assertFalse(WebUI.checkElementExist(By.xpath("//tbody/tr[1]/td[2]")), "The record has not been deleted");
    }

    public void verifyAddContactForClientSuccess(String companyName) {
        WebUI.waitForElementVisible(alertaddContactSuccess);
        Assert.assertTrue(WebUI.checkElementExist(alertaddContactSuccess, 5, 1000), "Add Contact For Client not success");

        // Vào Tab Contact check xem có không
        clickMenuClients();
        clickTabContacts();
        WebUI.setText(inputSearchClient, companyName);
        WebUI.sleep(2);
        Assert.assertEquals(WebUI.getElementText(By.xpath("//tbody/tr[1]/td[3]")), companyName, "Add Contact For Client not success");


    }


}
