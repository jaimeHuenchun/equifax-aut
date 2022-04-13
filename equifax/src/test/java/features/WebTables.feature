@WebTables
Feature:Agregar Editar y Eliminar Datos del WebTable

  Background:
    Given Dado que tengo desplegado el navegador "Chrome" con la url "URL"
    And Selecciono el elemento Web Tables del menu lateral izquierdo
    And Se despliega la tabla de manejo de datos

    @ADD
  Scenario: Como usuario existente quiero agregar un dato a la tabla
    When Hago clic en el boton "ADD" de la tabla
    And Ingreso los datos solicitadom del formulario desplegado
    And Hago clic en Submit del formulario desplegado
    Then Se agrega una nueva fila a la tabla con los datos ingresados

      @EDIT
  Scenario: Como usuario existente quiero editar un dato a la tabla

    When Hago clic en el boton "Edit" de una fila de la tabla
    And Edito los datos del formulario desplegado
    And Hago clic en Submit del formulario desplegado
    Then Se modifican los datos en la fila seleccionada de la tabla


        @DELETE
  Scenario: Como usuario existente quiero eliminar un dato a la tabla

    When Hago clic en el boton "Delete" de una fila de la tabla
    Then Se elimina la fila seleccionada de la tabla
