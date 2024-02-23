package cucumber.StepPF;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import config.env;
import cucumber.mobilePF.IsiFormPF;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IsiFormStep extends env {


    @Given("User berhasil Login")
    public void user_berhasil_login() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "sdk_gphone_x86");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platfromVersion", "11.0");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", System.getProperty("user.dir")+"/src/test/java/apk/testing-app.apk"); //set apk file directory
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("noReset", true); 

        URL url = new URL(baseUrl);
        driver = new AndroidDriver(url,capabilities); //open app

        //waiting
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        IsiFormPF isiForm = new IsiFormPF(driver);
        isiForm.login("user", "user123");
    }
    @When("User klik button Isi Form")
    public void user_klik_button_isi_form() {
        IsiFormPF isiForm = new IsiFormPF(driver);
        isiForm.klikBtnIsi();
    }
    @When("User isi data form")
    public void user_isi_data_form() {
        IsiFormPF isiForm = new IsiFormPF(driver);
        isiForm.isiForm("test", "021545", "test", "Jl.Test", "12014");
    }
    @When("User klik button Submit")
    public void user_klik_button_submit() {
        IsiFormPF isiForm = new IsiFormPF(driver);
        isiForm.klikSubmit();
    }
    @Then("User berhasil submit form")
    public void user_berhasil_submit_form() {
        IsiFormPF isiForm = new IsiFormPF(driver);
        isiForm.verify();
    }
}
