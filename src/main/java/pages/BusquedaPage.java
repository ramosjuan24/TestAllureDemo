package pages;

import datos.Clientes;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ambientes.AbstractScreen;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @autor Juan C. Ramos P Inovabiz
 */
public class BusquedaPage extends AbstractScreen {

    public BusquedaPage(WebDriver driver) {
        super(driver);
    }

    @Step("Busqueda de Operacion por Rut del Cliente")
    public void doBusquedaRut(Clientes client) throws Exception {

        try {



            Thread.sleep(3000);
            //Verificamos si el elemento de mensaje se muestra
            boolean busquedaExito = waitForElement(By.xpath("//button")).isDisplayed();
            Assert.assertTrue(busquedaExito);

            //Verificamos que el nombre del mensaje sea éxitoso
            String nameMessage = waitForElement(By.xpath("/html/body/app-root/notifier-container/ul/li/notifier-notification/p")).getText();
            Assert.assertEquals("Busqueda realizada con \u00e9xito", nameMessage);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Step("Busqueda de Operacion por Rut y estado de la operacion")
    public void doBusquedaRutEstado(String rut, String estado) throws Exception {

        try {


            waitForElement(By.xpath("//button[3]")).click(); //Para Versión Responsiva
            //waitForElement(By.xpath("//mat-dialog-actions/div/button[2]")).click();
            Thread.sleep(2000);
            //Verificamos que el nombre del mensaje sea éxitoso
            String nameMessage = waitForElement(By.xpath("//simple-snack-bar/span")).getText(); //Nueva version responsiva
            //String nameMessage = waitForElement(By.xpath("/html/body/app-root/notifier-container/ul/li/notifier-notification/p")).getText();
            //Assert.assertEquals("Nombre del mensaje correcto", "Busqueda realizada con \u00e9xito", nameMessage); cambió por BUSQUEDA REALIZADA CON ÉXITO
            Assert.assertEquals("Busqueda realizada con \u00e9xito", nameMessage);
            Thread.sleep(3000);
            sacarPantallazo("Formulario de Busqueda - 3");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


}
