package cucumber.mobilePage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class IsiFormPage {

        AndroidDriver driver;

        By username = By.id("com.example.testingapps:id/user");
        By pass = By.id("com.example.testingapps:id/sandi");
        By btnlogin = By.id("com.example.testingapps:id/btnlogin");
        By btnIsi = By.id("com.example.testingapps:id/btnIsi");
        By nama = By.id("com.example.testingapps:id/nama");
        By notelp = By.id("com.example.testingapps:id/notelp");
        By email = By.id("com.example.testingapps:id/email");
        By alamat = By.id("com.example.testingapps:id/alamat");
        By kodepos = By.id("com.example.testingapps:id/kodepos");
        By jk_lk = By.id("com.example.testingapps:id/jk_lk");
        By jk_pr = By.id("com.example.testingapps:id/jk_pr");
        By btnSubmit = By.id("com.example.testingapps:id/btnSubmit");
        By data_view = By.id("com.example.testingapps:id/data_view");
        By toastMsg = By.xpath("(//android.widget.Toast)");

        public IsiFormPage(AndroidDriver driver) {
                this.driver = driver;
        }

        public void login(String uname, String pwd){
                driver.findElement(username).sendKeys(uname);
                driver.findElement(pass).sendKeys(pwd);
                driver.findElement(btnlogin).click();
        }

        public void klikBtnIsi() {
                driver.findElement(btnIsi).click();
        }

        public void isiForm(String name, String telp, String mail, String address, String kode){
                Random rand = new Random();
                int userRand = rand.nextInt(10000);

                driver.findElement(nama).sendKeys(name+userRand);
                driver.findElement(notelp).sendKeys(telp);
                driver.findElement(email).sendKeys(mail+userRand+"@test.com");
                driver.findElement(alamat).sendKeys(address);
                driver.findElement(kodepos).sendKeys(kode);
                driver.findElement(jk_lk).click();
        }

        public void klikSubmit() {
                //waiting
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                driver.findElement(btnSubmit).click();
        }

        public void verify(){
                WebElement toast = driver.findElement(toastMsg);
                String message = toast.getText();
                System.out.println(message);
                driver.findElement(data_view).isDisplayed();
                driver.quit();
        }
}
