package pages;

import ambientes.AbstractScreen;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @autor Juan C. Ramos P Inovabiz
 */
public class HeaderPage extends AbstractScreen {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    private int tempo = 1000;
    private String texto1 = "Marketplace";
    private String texto2 = "Servicios de consultor\u00eda";
    private String texto3 = "IBM Cloud Paks";
    private String texto4 = "Nuestros productos";

    @Step("Valida Logotipo header")
    public void doLogotipoHeader() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            Thread.sleep(3000);
            WebElement logotipo = waitForElement(By.xpath("//a"));
            boolean logo = logotipo.isDisplayed();
            Thread.sleep(tempo);
            sacarPantallazo("logotipo de Empresa");
            Assert.assertTrue(logo);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }

    @Step("Valida Menu MarketPlace")
    public void doMenuMarketPlace() throws Exception {

        try {

            waitForElement(By.xpath("//li/a")).click();
            Thread.sleep(tempo);
            sacarPantallazo("MarketPlace");
            Thread.sleep(tempo);
            String market = waitForElement(By.xpath("//h3/a")).getText();
            Assert.assertEquals(texto1, market);


        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }

    @Step("Valida Menu Servicios")
    public void doMenuServicios() throws Exception {

        try {

            waitForElement(By.xpath("//li[2]/a")).click();
            Thread.sleep(tempo);
            sacarPantallazo("Servicios");
            Thread.sleep(tempo);
            String servicios = waitForElement(By.xpath("//div[2]/div/div[2]/div/h3/a")).getText();
            Assert.assertEquals(texto2, servicios);


        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }

    @Step("Valida Menu Soluciones")
    public void doMenuSoluciones() throws Exception {

        try {

            waitForElement(By.xpath("//li[3]/a")).click();
            Thread.sleep(tempo);
            sacarPantallazo("Soluciones");
            Thread.sleep(tempo);
            doMenuCloudPack();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }

    @Step("Valida Menu Cloud Pack")
    private void doMenuCloudPack() throws Exception {

        try {

            waitForElement(By.xpath("//li[3]/ul/li/a")).click();
            Thread.sleep(tempo);
            sacarPantallazo("Menu Cloud Pack");
            Thread.sleep(tempo);

            String ibm = waitForElement(By.xpath("//h1")).getText();
            Assert.assertEquals(texto3, ibm);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }

    @Step("Valida Carrusel Clientes")
    public void doCarruselClientes() throws Exception {

        try {

            waitForElement(By.xpath("//div[2]/ul/li[2]/a")).click();
            Thread.sleep(tempo);
            sacarPantallazo("Carrusel Clientes 1");
            waitForElement(By.xpath("//div[2]/ul/li[2]/a")).click();
            Thread.sleep(tempo);
            sacarPantallazo("Carrusel Clientes 2");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }

    @Step("Valida Menu Productos")
    public void doMenuProductos() throws Exception {

        try {

            waitForElement(By.xpath("//li[4]/a")).click();
            Thread.sleep(tempo);
            sacarPantallazo("Menu Productos");

            String productos = waitForElement(By.xpath("//section[5]/div/div/div/h2")).getText();
            Assert.assertEquals(texto4, productos);


        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }



}
