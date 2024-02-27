package cucumber.stepDef;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import config.env;
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
        driver.findElement(By.id("com.example.testingapps:id/user")).sendKeys("user");
        driver.findElement(By.id("com.example.testingapps:id/sandi")).sendKeys("user123");
        driver.findElement(By.id("com.example.testingapps:id/btnlogin")).click();
    }
    @When("User klik button Isi Form")
    public void user_klik_button_isi_form() {
        driver.findElement(By.id("com.example.testingapps:id/btnIsi")).click();
    }
    @When("User isi data form")
    public void user_isi_data_form() {
        Random rand = new Random();
        int userRand = rand.nextInt(10000);

        driver.findElement(By.id("com.example.testingapps:id/nama")).sendKeys("test"+userRand);
        driver.findElement(By.id("com.example.testingapps:id/notelp")).sendKeys("021454565");
        driver.findElement(By.id("com.example.testingapps:id/email")).sendKeys("test"+userRand+"@test.com");
        driver.findElement(By.id("com.example.testingapps:id/alamat")).sendKeys("jl. mawar");
        driver.findElement(By.id("com.example.testingapps:id/kodepos")).sendKeys("12403");
        driver.findElement(By.id("com.example.testingapps:id/jk_lk")).click();
    }
    @When("User klik button Submit")
    public void user_klik_button_submit() {
        //waiting
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("com.example.testingapps:id/btnSubmit")).click();
    }
    @Then("User berhasil submit form")
    public void user_berhasil_submit_form() {
        WebElement toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)"));
        String message = toastMsg.getText();
        System.out.println(message);
        driver.findElement(By.id("com.example.testingapps:id/data_view")).isDisplayed();
        driver.quit();
    }
}
