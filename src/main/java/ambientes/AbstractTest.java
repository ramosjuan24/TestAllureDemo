package ambientes;


import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AbstractTest {

    public App app;
    public WebDriver driver;

    private String url = null;
    private String platform = null;
    private String carga = null;
    public static String rutaEvidencia;
    public static String fechaEjecucion;
    public static String fechaEjecucion2;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void connect() {

        int pageLoadTimeout = 9;
        leerProperties();

        try {

            if (platform.equals("chrome")) {

                pageLoadTimeout = Integer.parseInt(carga);
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("credentials_enable_service", false);
                prefs.put("password_manager_enabled", false);

                final String regex = "^\\D*$";
                final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
                final Matcher matcher = pattern.matcher(System.getProperty("user.name"));
                boolean isHuman = matcher.matches();

                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("disable-infobars");
                options.addArguments("--incognito");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--allow-insecure-localhost");

                if (isHuman) {
                    //logger.info("Chrome starting maximized - isHuman: " + isHuman + " process run by " + System.getProperty("user.name"));
                    options.addArguments("--start-maximized");
                } else {
                    //logger.info("Chrome starting headless - isHuman: " + isHuman + " process run by " + System.getProperty("user.name"));
                    options.addArguments("--headless");
                    options.addArguments("--window-size=1366,768");
                }

                DateTime timeStamp = new DateTime();
                fechaEjecucion = timeStamp.toString("yyyyMMdd-HHmmss");
                fechaEjecucion2 = timeStamp.toString("yyyyMMdd");
                //Inicio de la Ejecución
                System.out.println("Inicio de Ejecucion_ " + timeStamp.toString("yyyyMMdd-HHmmss"));
                System.out.println("Browser_ " + platform);
                System.out.println("URL Ambiente_ " + url);

                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(pageLoadTimeout, TimeUnit.SECONDS);
                driver.get(url);


            }  else {

                System.out.println("No se encontr\u00f3 ninguna plataforma v\u00e1lida");

            }

        } catch (Exception e) {

            System.out.println("Utilizando carga m\u00e1xima de p\u00e1gina por omisi\u00f3n de " + pageLoadTimeout);
            e.printStackTrace();
            throw e;
        }

        app = new App(driver);

    }

    @BeforeMethod
    private void leerProperties() {


        try {

            Properties propiedades = new Properties();
            propiedades.load(getClass().getClassLoader().getResourceAsStream("allure.properties"));

            url = propiedades.getProperty("URL");
            platform = propiedades.getProperty("AMBIENTE");
            carga = propiedades.getProperty("TIME_OUT_CARGA_PAGINA");
            rutaEvidencia = propiedades.getProperty("TEST_NAME");

        } catch (FileNotFoundException e) {
            System.out.println("Error, El archivo no exite");
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Error, No se puede leer el archivo");
        }
    }

    private void analyzeLog() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            //do something useful with the data
        }
    }

    @AfterClass
    public void teardown() {
        analyzeLog();
        driver.quit();
    }
}