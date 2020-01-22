package tests;

import ambientes.AbstractTest;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.Listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regresión Formulario de Registro IBM")
@Feature("Formulario de Registro Tests")
public class FormularioRegistroTest extends AbstractTest {


    @Test(description = "Escenario Enviar mensajes por formulario de contacto", enabled = false)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Prueba para verificación de envío de formulario")
    @Story("Formulario de Contacto")
    public void enviarMensajeConFormulario() throws Exception {

        app.PantallaHeader().doMenuSoluciones();
        app.PantallaContacto().doClickRegistro();
        app.PantallaContacto().doIngresoCorreo("j.corbanca@banca.com");
        app.PantallaContacto().doIngresoNombre();
        app.PantallaContacto().doIngresoApellido();
        app.PantallaContacto().doIngresoClave();
        app.PantallaContacto().doClickBtnRegistrar();
        app.PantallaContacto().doValidaMensaje();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}