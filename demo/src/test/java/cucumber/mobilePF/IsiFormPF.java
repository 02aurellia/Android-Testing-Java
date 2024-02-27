package cucumber.mobilePF;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import io.appium.java_client.android.AndroidDriver;

public class IsiFormPF {

        AndroidDriver driver;

        @FindBy(id = "com.example.testingapps:id/user")
        @CacheLookup //ensure the web elements load just once and do not have to reload whenever the method is called
        WebElement username;

        @FindBy(id = "com.example.testingapps:id/sandi")
        WebElement pass;

        @FindBy(id = "com.example.testingapps:id/btnlogin")
        WebElement btnlogin;

        @FindBy(id = "com.example.testingapps:id/btnIsi")
        WebElement btnIsi;

        @FindBy(id = "com.example.testingapps:id/btnSubmit")
        WebElement btnSubmit;
        
        @FindBy(id = "com.example.testingapps:id/nama")
        WebElement nama;

        @FindBy(id = "com.example.testingapps:id/notelp")
        WebElement notelp;

        @FindBy(id = "com.example.testingapps:id/email")
        WebElement email;

        @FindBy(id = "com.example.testingapps:id/alamat")
        WebElement alamat;

        @FindBy(id = "com.example.testingapps:id/kodepos")
        WebElement kodepos;

        @FindBy(id = "com.example.testingapps:id/jk_lk")
        WebElement jk_lk;

        @FindBy(id = "com.example.testingapps:id/jk_pr")
        WebElement jk_pr;

        @FindBy(id = "com.example.testingapps:id/data_view")
        WebElement data_view;

        @FindBy(xpath = "(//android.widget.Toast)")
        WebElement toastMsg;

        public IsiFormPF(AndroidDriver driver) {
                this.driver = driver;
                PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
        }

        public void login(String uname, String pwd){
                username.sendKeys(uname);
                pass.sendKeys(pwd);
                btnlogin.click();
        }

        public void klikBtnIsi() {
                btnIsi.click();
        }

        public void isiForm(String name, String telp, String mail, String address, String kode){
                Random rand = new Random();
                int userRand = rand.nextInt(10000);

                nama.sendKeys(name+userRand);
                notelp.sendKeys(telp);
                email.sendKeys(mail+userRand+"@test.com");
                alamat.sendKeys(address);
                kodepos.sendKeys(kode);
                jk_lk.click();
        }

        public void klikSubmit() {
                //waiting
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                btnSubmit.click();
        }

        public void verify(){
                String message = toastMsg.getText();
                System.out.println(message);
                data_view.isDisplayed();
                driver.quit();
        }
}
