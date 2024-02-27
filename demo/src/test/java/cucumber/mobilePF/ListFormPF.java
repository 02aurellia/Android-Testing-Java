package cucumber.mobilePF;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import io.appium.java_client.android.AndroidDriver;

public class ListFormPF {

        AndroidDriver driver;

        @FindBy(id = "com.example.testingapps:id/button_edit_data")
        @CacheLookup //ensure the web elements load just once and do not have to reload whenever the method is called
        WebElement btnEdit;

        @FindBy(id = "com.example.testingapps:id/button_delete_data")
        WebElement btnDelete;

        @FindBy(id = "com.example.testingapps:id/btnSubmit")
        WebElement btnSubmit;

        @FindBy(id = "com.example.testingapps:id/btnBatal")
        WebElement btnBatal;

        @FindBy(id = "com.example.testingapps:id/data_view")
        WebElement data_view;

        @FindBy(id = "android:id/text1")
        WebElement data1;

        @FindBy(id = "com.example.testingapps:id/nama")
        WebElement nama;

        @FindBy(id = "com.example.testingapps:id/jk_lk")
        WebElement jk_lk;

        @FindBy(id = "com.example.testingapps:id/jk_pr")
        WebElement jk_pr;

        @FindBy(xpath = "(//android.widget.Toast)")
        WebElement toastMsg;

        public ListFormPF(AndroidDriver driver) {
                this.driver = driver;
                PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
        }

        public void pilihData() {
                new Actions(driver).clickAndHold(data1).perform();
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }

        public void lihatData() throws InterruptedException {
                data1.click();
                Thread.sleep(1000);
                driver.navigate().back();
        }

        public void isiData(String name) {
                btnEdit.click();
                
                nama.clear();
                nama.sendKeys(name);
                jk_pr.click();
        }

        public void klikSubmit() {
                btnSubmit.click();
        }

        public void verify() {
                data_view.isDisplayed();
        }

        public void verifydel() {
                String message = toastMsg.getText();
                if (message.contains("Data berhasil di hapus")) {
                        System.out.println("Verify " + message + " berhasil");
                        driver.quit();  
                } 
                else {
                        System.out.println("Verify " + message + " tidak berhasil");
                }
        }

        public void klikBatal() {
                btnEdit.click();
                btnBatal.click();
        }

        public void klikHapus() {
                btnDelete.click();
        }
}
