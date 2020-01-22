package pages;

import datos.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ambientes.AbstractScreen;
import org.testng.Assert;

public class LoginPage extends AbstractScreen {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**Page Methods*/
    @Step("Login Step con username: {0}, password: {1}, for method: {method} step...")
    public void doLoginFinexPlus(User username) throws Exception {

        try {

            ingresaUsername(username.rutUsuario);
            ingresaPassword(username.password);
            clickIngreso();
            validaNameUser(username.nombre);

        } catch (Exception e) {
            throw e;

        }
    }

    @Step("Ingresa nombre de usuario {0}")
    private void ingresaUsername(String user) throws Exception {

        sacarPantallazo("Home");
        waitForElement(By.id("username")).click();
        waitForElement(By.id("username")).clear();
        waitForElement(By.id("username")).sendKeys(user);

    }

    @Step("Ingresar contraseña {1}")
    private void ingresaPassword(String pass) throws Exception {

        waitForElement(By.id("password")).click();
        waitForElement(By.id("password")).clear();
        waitForElement(By.id("password")).sendKeys(pass);
        sacarPantallazo("Login-1");

    }

    @Step("Realiza Clic en Ingresar")
    private void clickIngreso() throws Exception {

        waitForElement(By.id("password")).click();
        waitForElement(By.id("kc-login")).click();
        Thread.sleep(6000);
        sacarPantallazo("Login-2");

    }

    @Step("Valida nombre de Usuario")
    private void validaNameUser(String nombreUsuario) throws Exception{

        String nombre = waitForElement(By.xpath("//span")).getText();
        Assert.assertEquals(nombreUsuario, nombre);
    }

}