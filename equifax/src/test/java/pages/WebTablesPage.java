package pages;

import driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage {
    public WebTablesPage() {
        PageFactory.initElements(Driver.getDriverWeb(), this);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/div")
    private WebElement menuLateral;

    @FindBy(xpath = "//*[@id=\"item-3\"]")
    private WebElement btnWebTablesMenuLateral;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]")
    private WebElement webTable;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/button")
    private WebElement btnAddWebTable;

    @FindBy(xpath = "//*[@id=\"edit-record-1\"]")
    private WebElement btnEditWebTable;

    @FindBy(xpath = "//*[@id=\"delete-record-1\"]")
    private WebElement btnDeleteWebTable;

    public WebElement getBtnWebTablesMenuLateral() {
        return btnWebTablesMenuLateral;
    }

    public WebElement getBtnAddWebTable() {
        return btnAddWebTable;
    }

    public WebElement getBtnEditWebTable() {
        return btnEditWebTable;
    }

    public WebElement getBtnDeleteWebTable() {
        return btnDeleteWebTable;
    }

    public WebElement getWebTable() {
        return webTable;
    }

    public boolean validarFilaCreada(String firstName, String lastName, String userEmail, String age, String salary, String departament) {
        boolean filaEncontrada = false;
        List<WebElement> rows = webTable.findElements(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[*]"));
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).getText().length() > 7) {
                //Validamos los datos solo si hay contenido dentro de la fila
                if (rows.get(i).getText().contains(firstName + "\n" + lastName + "\n" + age + "\n" + userEmail + "\n" + salary + "\n" + departament)) {
                    filaEncontrada = true;
                    break;
                }
            }
        }
        return filaEncontrada;
    }

    public int getCantFilas() {
        int cont = 0;
        List<WebElement> rows = webTable.findElements(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[*]"));
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).getText().length() > 7) {
                //Validamos los datos solo si hay contenido dentro de la fila
                cont = cont + 1;
            }
        }
        return cont;
    }
}
