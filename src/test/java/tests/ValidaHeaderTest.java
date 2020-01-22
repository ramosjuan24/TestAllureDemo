package tests;

import ambientes.AbstractTest;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Listeners.TestListener;

/**
 * @autor Juan C. Ramos P Inovabiz
 */

@Listeners({TestListener.class})
@Epic("Regresión ValidarHeaderTest")
@Feature("Header Test")
public class ValidaHeaderTest extends AbstractTest {

    @Test(description = "Escenario Header")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Verificación de elementos del Header de la aplicación")
    @Story("Header de página web de inovabiz")
    public void validaHeader() throws Exception {

        app.PantallaHeader().doLogotipoHeader();
        app.PantallaHeader().doMenuMarketPlace();
        app.PantallaHeader().doMenuServicios();
        app.PantallaHeader().doMenuSoluciones();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }


}
