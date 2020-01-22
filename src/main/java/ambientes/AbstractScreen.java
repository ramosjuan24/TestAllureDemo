package ambientes;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.concurrent.TimeUnit;

import static ambientes.AbstractTest.*;

/**
 * @autor Juan C. Ramos P Inovabiz
 */
public class AbstractScreen{

    protected WebDriver driver;
    private long timeout;
    private long timeOutWebElement = 5;

    protected AbstractScreen(WebDriver driver) {
        this.driver = driver;
    }

    private long getTimeout() {

        if (timeout == 0) {
            try {
                timeout = timeOutWebElement;
                if (timeout == 0) {
                    timeout = 3;
                }
            } catch (Exception error) {
                timeout = 3;
            }
        }
        return timeout;
    }

    public WebElement waitForElement(By locator) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, getTimeout());

        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            sacarPantallazo("Elemento no encontrado");
            throw e;
        }
    }


    /**
     * Método para capturar evidencia de flujos automatizados
     * recibe el @nombre de la imagen
     */
    public void sacarPantallazo(String nombre) throws Exception {

        try {

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            //File screenshot = driver.getScreenshotAs(OutputType.FILE);

            File directory = new File("build/reports/");

            if (!directory.exists()) {
                FileUtils.forceMkdir(directory);

            }
            DateTime timeStamp = new DateTime();
            //Se guardan la carpeta screenshots dentro de carpeta definida en TEST_NAME
            directory = new File(directory.getPath()  + "/" + rutaEvidencia + "/" +  fechaEjecucion2);

            if (!directory.exists()) {
                FileUtils.forceMkdir(directory);
            }
            directory = new File(directory.getPath()  + "/" + rutaEvidencia + "/" +  fechaEjecucion + "/screenshots");
            if (!directory.exists()) {
                FileUtils.forceMkdir(directory);
            }
            File filename = new File(directory.getPath() + "/" + timeStamp.toString("yyyyMMdd-HHmmss") + "-" + nombre + ".png");
            FileUtils.copyFile(screenshot, filename);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception while saving the file " + e);
        }
    }


    /**
     * Método para leer archivo masivo de RUT tanto de
     * Personas Jurídicas como de Naturales
     */

    public WebElement scrollElement(By locator) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, getTimeout());

        try {

            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            sacarPantallazo("Elemento no encontrado");
            throw e;
        }
    }


}
