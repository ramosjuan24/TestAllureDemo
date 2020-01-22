package pages;

import ambientes.AbstractScreen;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.TreeMap;

/**
 * @autor Juan C. Ramos P Inovabiz
 */
public class ContactoPage extends AbstractScreen {

    public ContactoPage(WebDriver driver) {
        super(driver);
    }


    private int tempo = 1000;
    private String texto1 = "Error durante el registro";



    @Step("Clic en Registro")
    public void doClickRegistro() throws Exception {

        try {
            waitForElement(By.xpath("//div[5]/ul/li/a")).click();
            Thread.sleep(tempo);
            sacarPantallazo("Clic en registro");

        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }

    @Step("Ingresamos correo")
    public void doIngresoCorreo(String correo) throws Exception {

        try {
            waitForElement(By.xpath("//input")).click();
            Thread.sleep(tempo);
            waitForElement(By.xpath("//input")).sendKeys(correo);
            Thread.sleep(tempo);
            sacarPantallazo("Correo");

        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }
    @Step("Ingresamos Nombre")
    public void doIngresoNombre() throws Exception {

        try {
            waitForElement(By.xpath("//div[6]/input")).click();
            Thread.sleep(tempo);
            waitForElement(By.xpath("//div[6]/input")).sendKeys("Juan Carlos");
            Thread.sleep(tempo);
            sacarPantallazo("nombre");

        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }

    @Step("Ingresamos Apellido")
    public void doIngresoApellido() throws Exception {

        try {
            waitForElement(By.xpath("//div[7]/input")).click();
            Thread.sleep(tempo);
            waitForElement(By.xpath("//div[7]/input")).sendKeys("Ramirez");
            Thread.sleep(tempo);
            sacarPantallazo("apellido");

        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }

    @Step("Ingresamos Clave")
    public void doIngresoClave() throws Exception {

        try {
            waitForElement(By.xpath("//div[11]/input")).click();
            Thread.sleep(tempo);
            waitForElement(By.xpath("//div[11]/input")).sendKeys("Huioo123456");
            Thread.sleep(tempo);
            sacarPantallazo("clave");

        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }

    @Step("Clic en Registrar")
    public void doClickBtnRegistrar() throws Exception {

        try {
            waitForElement(By.xpath("//button")).click();
            Thread.sleep(tempo);
            sacarPantallazo("registro");
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }


    @Step("Validamos Mensajes")
    public void doValidaMensaje() throws Exception {

        try {
            String mensaje = waitForElement(By.xpath("//p")).getText();
            Assert.assertEquals(texto1, mensaje);
            Thread.sleep(tempo);
            sacarPantallazo("mensaje");

        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }




}
