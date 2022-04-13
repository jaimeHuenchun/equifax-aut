package stepDefinitions;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.FormularioPage;
import pages.WebTablesPage;


public class WebTablesStepDefinitions {
    private String firstName = "Jaime";
    private String lastName = "Huenchun";
    private String userEmail = "Jaime@gmail.com";
    private String age = "28";
    private String salary = "400000";
    private String departament = "QA";
    int CantidadFilas = 0;


    @Given("Dado que tengo desplegado el navegador {string} con la url {string}")
    public void dadoQueTengoDesplegadoElNavegadorConLaUrl(String navegador, String url) {

        Driver.resolveDriver("Chrome", "chromedriver", "https://demoqa.com/webtables");

        System.out.println("??");
    }

    @And("Selecciono el elemento Web Tables del menu lateral izquierdo")
    public void seleccionoElElementoWebTablesDelMenuLateralIzquierdo() {
        WebTablesPage webTables = new WebTablesPage();
        webTables.getBtnWebTablesMenuLateral().click();

    }

    @And("Se despliega la tabla de manejo de datos")
    public void seDespliegaLaTablaDeManejoDeDatos() {
        WebTablesPage webTables = new WebTablesPage();
        if (!webTables.getBtnAddWebTable().isDisplayed()) {
            Assert.fail("No se despliega Web Table");
        }

    }

    @When("Hago clic en el boton {string} de la tabla")
    public void hagoClicEnElBotonDeLaTabla(String boton) {
        WebTablesPage webTables = new WebTablesPage();
        switch (boton) {
            case "ADD":
                webTables.getBtnAddWebTable().click();
                break;
        }
    }


    @And("Ingreso los datos solicitadom del formulario desplegado")
    public void ingresoLosDatosSolicitadomDelFormularioDesplegado() {
        System.out.println("Se Despliega Formulario");
        FormularioPage formulario = new FormularioPage();
        formulario.getFirstNameInput().sendKeys(firstName);
        formulario.getLastNameInput().sendKeys(lastName);
        formulario.getUserEmailInput().sendKeys(userEmail);
        formulario.getAgeInput().sendKeys(age);
        formulario.getSalaryInput().sendKeys(salary);
        formulario.getDepartmentInput().sendKeys(departament);

    }

    @And("Hago clic en Submit del formulario desplegado")
    public void hagoClicEnSubmitDelFormularioDesplegado() {
        FormularioPage formulario = new FormularioPage();
        formulario.getBtnSubmit().click();
    }

    @Then("Se agrega una nueva fila a la tabla con los datos ingresados")
    public void seAgregaUnaNuevaFilaALaTablaConLosDatosIngresados() {
        System.out.println("Validamos nuva fila");
        WebTablesPage webTables = new WebTablesPage();
        if (webTables.validarFilaCreada(firstName, lastName, userEmail, age, salary, departament)) {
            System.out.println("La fila se registro correctamente en la tabla.");
            Assert.assertTrue("La fila se registro correctamente en la tabla.", true);
        } else {
            System.out.println("La fila no se registro en la tabla.");
            Assert.fail("La fila no se registro en la tabla.");
        }
        Driver.quitDriverWeb();
    }

    @When("Hago clic en el boton {string} de una fila de la tabla")
    public void hagoClicEnElBotonDeUnaFilaDeLaTabla(String boton) {
        WebTablesPage webTables = new WebTablesPage();
        switch (boton) {
            case "Edit":
                webTables.getBtnEditWebTable().click();
                break;
            case "Delete":
                CantidadFilas = webTables.getCantFilas();
                System.out.println("Cantidad Fila Actual:" + CantidadFilas);
                webTables.getBtnDeleteWebTable().click();
                break;
        }
    }

    @And("Edito los datos del formulario desplegado")
    public void editoLosDatosDelFormularioDesplegado() {
        System.out.println("Se Despliega Formulario");
        FormularioPage formulario = new FormularioPage();
        formulario.getFirstNameInput().clear();
        formulario.getFirstNameInput().sendKeys(firstName);
        formulario.getLastNameInput().clear();
        formulario.getLastNameInput().sendKeys(lastName);
        formulario.getUserEmailInput().clear();
        formulario.getUserEmailInput().sendKeys(userEmail);
        formulario.getAgeInput().clear();
        formulario.getAgeInput().sendKeys(age);
        formulario.getSalaryInput().clear();
        formulario.getSalaryInput().sendKeys(salary);
        formulario.getDepartmentInput().clear();
        formulario.getDepartmentInput().sendKeys(departament);
    }

    @Then("Se modifican los datos en la fila seleccionada de la tabla")
    public void seModificanLosDatosEnLaFilaSeleccionadaDeLaTabla() {
        WebTablesPage webTables = new WebTablesPage();
        if (webTables.validarFilaCreada(firstName, lastName, userEmail, age, salary, departament)) {
            System.out.println("Los datos de la fila se modificaron correctamente en la tabla.");
            Assert.assertTrue("Los datos de la fila se modificaron correctamente en la tabla.", true);
        } else {
            System.out.println("Los datos de la fila no se modificaron en la tabla.");
            Assert.fail("Los datos de la fila no se modificaron en la tabla.");
        }
        Driver.quitDriverWeb();
    }

    @Then("Se elimina la fila seleccionada de la tabla")
    public void seEliminaLaFilaSeleccionadaDeLaTabla() {
        WebTablesPage webTables = new WebTablesPage();
        System.out.println("Cantidad Fila Actual:" + webTables.getCantFilas());
        if (CantidadFilas - 1 == webTables.getCantFilas()) {
            Assert.assertTrue("La fila se elimino correctamente de la tabla.", true);
        } else {
            Assert.fail("La fila no se elimino de la tabla.");
        }
        Driver.quitDriverWeb();
    }
}
