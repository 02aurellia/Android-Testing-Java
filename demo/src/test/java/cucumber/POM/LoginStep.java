package cucumber.POM;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import config.env;
import cucumber.mobilePage.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep extends env {

    @Given("Buka Aplikasi")
    public void buka_aplikasi() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "sdk_gphone_x86");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platfromVersion", "11.0");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", System.getProperty("user.dir")+"/src/test/java/apk/testing-app.apk"); //set apk file directory
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoAcceptAlerts", true);
        // capabilities.setCapability("noReset", true); 

        URL url = new URL(baseUrl);
        driver = new AndroidDriver(url,capabilities); //open app

        //waiting
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    @When("Input Data")
    public void input_data() {
        
        LoginPage login = new LoginPage(driver);
        login.inputData("user", "user123");
    }
    @When("Klik Tombol Login")
    public void klik_tombol_login() {
        LoginPage login = new LoginPage(driver);
        login.klikLogin();
    }
    @Then("User masuk homepage")
    public void user_masuk_homepage() {
        LoginPage login = new LoginPage(driver);
        login.verifySukses();
        driver.quit();
    }

    @When("Input Data Salah")
    public void input_data_salah() {
        LoginPage login = new LoginPage(driver);
        login.inputData("salah", "user123");
    }
    @Then("User dapat alert")
    public void user_dapat_alert() {
        LoginPage login = new LoginPage(driver);
        login.verifyGagal();
        driver.quit();
    }
}
