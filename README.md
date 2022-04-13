# equifax-aut
El proyecto utiliza el patrón POM y Page Factory
El poryecto usa Cucumber, Junit, Selenium y esta desarrollado en Java
El proyecto fue desarrollado en MAC


#El SetUp

El archivo src/main/java/driver/Driver.java se setea el Driver Selenium con las configuraciones correspondientes, se parametriza el navegador.

En el fichero equifax/Drivers se deben guardar los drivers que se utilizaran (Chrome, Firefox, etc)

Para levantar el Driver se utiliza el metodo: Driver.resolveDriver("Chrome", "chromedriver", "https://demoqa.com/webtables"); 


#Feature

Se crea una feature con 3 scenarios, cada escenario realiza un flujo diferente y sus respectivas validaciones

El Scenario @ADD :  agrega una fila a la tabla y posterior a esto valida que se haya creaado una fila con los datos ingresados

El Scenario @EDIT:  Edita la primera fila de la tabla con los datos que nosotros le enviamos, posterior a esto valida que la fila tenga los datos ingresados.

El Scenario @DELETE: Elimina la primera fila de la tabla y despues valida que la cantidad de filas de latabla haya disminuido.


#Reporte

Se utiliza reporte HTML generado por cucumber, cuando se termina de ejecutar el proyecto se genera un. Target con el archivo cucumber-reports.html, el cual al abrirlo con un navegador podremos ver el estado de los escenarios y steps ejecutados.
