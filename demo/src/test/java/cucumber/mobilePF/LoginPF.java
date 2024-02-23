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
        btnIsi.isDisplayed();
        driver.quit();
    }

    public void verifyGagal() {
        btnlogin.isDisplayed();
        driver.quit();
    }
}
