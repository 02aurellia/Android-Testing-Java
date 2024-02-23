package cucumber.mobilePage;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
    AndroidDriver driver;

    By username = By.id("com.example.testingapps:id/user");
    By pass = By.id("com.example.testingapps:id/sandi");
    By btnlogin = By.id("com.example.testingapps:id/btnlogin");
    By btnIsi = By.id("com.example.testingapps:id/btnIsi");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void inputData(String uname, String pwd) {
        driver.findElement(username).sendKeys(uname);
        driver.findElement(pass).sendKeys(pwd);
    }

    public void klikLogin() {
        driver.findElement(btnlogin).click();
    }

    public void verifySukses() {
        driver.findElement(btnIsi).isDisplayed();
        driver.quit();
    }

    public void verifyGagal() {
        driver.findElement(btnlogin).isDisplayed();
        driver.quit();
    }
}
