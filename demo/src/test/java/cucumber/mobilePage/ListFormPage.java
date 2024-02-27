package cucumber.mobilePage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.android.AndroidDriver;

public class ListFormPage {

        AndroidDriver driver;

        By btnEdit = By.id("com.example.testingapps:id/button_edit_data");
        By btnDelete = By.id("com.example.testingapps:id/button_delete_data");
        By nama = By.id("com.example.testingapps:id/nama");
        By btnSubmit = By.id("com.example.testingapps:id/btnSubmit");
        By btnBatal = By.id("com.example.testingapps:id/btnBatal");
        By data_view = By.id("com.example.testingapps:id/data_view");
        By data1 = By.id("android:id/text1");
        By jk_lk = By.id("com.example.testingapps:id/jk_lk");
        By jk_pr = By.id("com.example.testingapps:id/jk_pr");
        By toastMsg = By.xpath("(//android.widget.Toast)");

        public ListFormPage(AndroidDriver driver) {
                this.driver = driver;
        }

        public void pilihData() {
                WebElement element = driver.findElement(data1);
                new Actions(driver).clickAndHold(element).perform();
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }

        public void lihatData() {
                driver.findElement(data1).click();
                driver.navigate().back();
        }

        public void isiData(String name) {
                driver.findElement(btnEdit).click();

                var el2 = driver.findElement(nama);
                el2.clear();
                el2.sendKeys(name);
                driver.findElement(jk_pr).click();
        }

        public void klikSubmit() {
                driver.findElement(btnSubmit).click();
        }

        public void verify() {
                driver.findElement(data_view).isDisplayed();
                WebElement toast = driver.findElement(toastMsg);
                String message = toast.getText();
                System.out.println(message);
        }

        public void verifyback() {
                driver.findElement(data_view).isDisplayed();
        }

        public void klikBatal() {
                driver.findElement(btnEdit).click();
                driver.findElement(btnBatal).click();
        }

        public void klikHapus() {
                driver.findElement(btnDelete).click();
        }

        public void verifydel() {
                WebElement toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)"));
                String message = toastMsg.getText();
                if (message.contains("Data berhasil di hapus")) {
                        System.out.println("Verify " + message + " berhasil");
                        driver.quit();  
                } 
                else {
                        System.out.println("Verify " + message + " tidak berhasil");
                }
        }
}
