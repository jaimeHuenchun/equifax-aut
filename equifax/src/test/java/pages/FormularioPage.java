package pages;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormularioPage {
    public FormularioPage() {
        PageFactory.initElements(Driver.getDriverWeb(), this);
    }

    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private WebElement firstNameInput;

    @FindBy(xpath = "//*[@id=\"lastName\"]")
    private WebElement lastNameInput;

    @FindBy(xpath = "//*[@id=\"userEmail\"]")
    private WebElement userEmailInput;

    @FindBy(xpath = "//*[@id=\"age\"]")
    private WebElement ageInput;

    @FindBy(xpath = "//*[@id=\"salary\"]")
    private WebElement salaryInput;

    @FindBy(xpath = "//*[@id=\"department\"]")
    private WebElement departmentInput;

    @FindBy(xpath = "//*[@id=\"submit\"]")
    private WebElement btnSubmit;



    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getUserEmailInput() {
        return userEmailInput;
    }

    public WebElement getAgeInput() {
        return ageInput;
    }

    public WebElement getSalaryInput() {
        return salaryInput;
    }

    public WebElement getDepartmentInput() {
        return departmentInput;
    }

    public WebElement getBtnSubmit() {
        return btnSubmit;
    }
}
