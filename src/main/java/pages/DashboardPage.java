package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ambientes.AbstractScreen;


/**
 * @autor Juan C. Ramos P Inovabiz
 */
public class DashboardPage extends AbstractScreen {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    private int tempo = 500;


    @Step("Ingreso de Pie")
    public void doPie(String monto) throws Exception {

        try {
            //Scroll hasta el elemento
            scrollElement(By.xpath("//div/app-sidebar/div/div[1]/div[1]/form/div[1]/mat-label"));
            Thread.sleep(tempo);
            //Input contaco
            waitForElement(By.xpath("//div[4]/div[2]/mat-form-field/div/div/div[2]")).click();
            Thread.sleep(tempo);
            waitForElement(By.xpath("//*[@id='mat-input-3']")).clear();
            waitForElement(By.xpath("//*[@id='mat-input-3']")).sendKeys(monto);
            Thread.sleep(tempo);
            sacarPantallazo("Ingreso de Pie");
            //Input retoma
            waitForElement(By.xpath("//div[3]/div[2]/mat-form-field/div/div/div[2]")).click();
            //Scroll en botón CalcularS
            scrollElement(By.xpath("//div[4]/button")); //para version responsiva
        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }

    @Step("Ingreso de Adicionales")
    public void doAdicionales() throws Exception {

        try {
            Thread.sleep(2000);
            scrollElement(By.xpath("//div[3]/a"));
            //Botón Adicionales
            waitForElement(By.xpath("//div[3]/a")).click(); //Para versión responsiva
            Thread.sleep(tempo);
            sacarPantallazo("Adicionales-1");
            //Input de Accesorios
            waitForElement(By.xpath("//app-sidebar-adicionales/div/div[2]/div/table/tbody/tr[2]/td/mat-checkbox/label/div")).click();
            Thread.sleep(tempo);
            waitForElement(By.xpath("//tr[2]/td[3]/input")).sendKeys("250000");
            Thread.sleep(tempo);
            sacarPantallazo("Adicionales-2");
            //Clic en botón Atrás
            waitForElement(By.xpath("//app-sidebar-adicionales/div/div/div/button")).click();
            Thread.sleep(2000);
            sacarPantallazo("Adicionales-3");
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

}
