package cucumber.mobilePF;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import io.appium.java_client.android.AndroidDriver;

public class LoginPF {
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

    @FindBy(xpath = "(//android.widget.Toast)")
    WebElement toastMsg;

    public LoginPF(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
    }

    public void inputData(String uname, String pwd) {
        username.sendKeys(uname);
        pass.sendKeys(pwd);
    }

    public void klikLogin() {
        btnlogin.click();
    }

    public void verifySukses() {
        // String message = toastMsg.getText();
        // System.out.println(message);
        // if (message.contains("Login Success")) {
        //     System.out.println("Verify Berhasil");
        // } 
        // else {
        //     System.out.println("Verify Tidak Berhasil");
        // }
        btnIsi.isDisplayed();
        driver.quit();
    }

    public void verifyGagal() {
        String message = toastMsg.getText();
        // System.out.println(message);
        if (message.contains("Failed Login")) {
            System.out.println("Verify " + message + " berhasil");
            driver.quit();  
        } 
        else {
            System.out.println("Verify " + message + " tidak berhasil");
        }
        // btnlogin.isDisplayed();
    }
}
