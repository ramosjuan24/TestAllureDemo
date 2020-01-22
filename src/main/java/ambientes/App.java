package ambientes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;


public class App extends AbstractTest {

    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public App(WebDriver driver) { this.driver = driver;
        wait = new WebDriverWait(driver,20);
    }
    public LoginPage PantallaLogin() { return new LoginPage(driver); }

    public BusquedaPage PantallaBusqueda() { return new BusquedaPage(driver); }

    public DashboardPage PantallaDashboard() { return new DashboardPage(driver); }

    public ContactoPage PantallaContacto() { return new ContactoPage(driver);}

    public HeaderPage PantallaHeader() { return new HeaderPage(driver);}



}