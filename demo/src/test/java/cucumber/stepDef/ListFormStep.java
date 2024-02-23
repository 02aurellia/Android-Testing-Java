package cucumber.stepDef;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import config.env;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ListFormStep extends env{

    @Given("User berhasil membuat data")
    public void user_berhasil_membuat_data() throws MalformedURLException {
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
        // driver.findElement(By.id("com.example.testingapps:id/user")).sendKeys("user");
        // driver.findElement(By.id("com.example.testingapps:id/sandi")).sendKeys("user123");
        // driver.findElement(By.id("com.example.testingapps:id/btnlogin")).click();
        // driver.findElement(By.id("com.example.testingapps:id/btnList")).click(); 

        // Random rand = new Random();
        // int userRand = rand.nextInt(10000);

        // driver.findElement(By.id("com.example.testingapps:id/btnIsi")).click();
        // driver.findElement(By.id("com.example.testingapps:id/nama")).sendKeys("test"+userRand);
        // driver.findElement(By.id("com.example.testingapps:id/notelp")).sendKeys("021454565");
        // driver.findElement(By.id("com.example.testingapps:id/email")).sendKeys("test"+userRand+"@test.com");
        // driver.findElement(By.id("com.example.testingapps:id/alamat")).sendKeys("jl. mawar");
        // driver.findElement(By.id("com.example.testingapps:id/kodepos")).sendKeys("12403");
        // driver.findElement(By.id("com.example.testingapps:id/jk_lk")).click();
        // driver.findElement(By.id("com.example.testingapps:id/btnSubmit")).click();
    }
    
    @When("User klik salah satu List")
    public void user_klik_salah_satu_list() {
        // final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        // var tapPoint = new Point(187, 575);
        // var tap = new Sequence(finger, 1);
        // tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
        //     PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        // tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        // tap.addAction(new Pause(finger, Duration.ofSeconds(5)));
        // tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        // driver.perform(Arrays.asList(tap));
        // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement element = driver.findElement(By.id("android:id/text1"));
        new Actions(driver).clickAndHold(element).perform();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @When("User isi ulang data")
    public void user_isi_ulang_data() {
        driver.findElement(By.id("com.example.testingapps:id/button_edit_data")).click();
        var el2 = driver.findElement(By.id("com.example.testingapps:id/nama"));
        el2.clear();
        el2.sendKeys("test ubah data");
        driver.findElement(By.id("com.example.testingapps:id/jk_lk")).click();
    }
    @When("User klik button Ubah")
    public void user_klik_button_ubah() {
        driver.findElement(By.id("com.example.testingapps:id/btnSubmit")).click();
    }
    @Then("Data berhasil diubah")
    public void data_berhasil_diubah() {
        driver.findElement(By.id("com.example.testingapps:id/data_view")).isDisplayed();
        driver.quit();
    }

    @When("User klik button Batal")
    public void user_klik_button_batal() {
        driver.findElement(By.id("com.example.testingapps:id/button_edit_data")).click();
        driver.findElement(By.id("com.example.testingapps:id/btnBatal")).click();
    }
    @Then("User kembali ke page List Form")
    public void user_kembali_ke_page_list_form() {
        driver.findElement(By.id("com.example.testingapps:id/data_view")).isDisplayed();
        driver.quit();
    }

    @When("User klik button Hapus")
    public void user_klik_button_hapus() {
        driver.findElement(By.id("com.example.testingapps:id/button_delete_data")).click();
    }

    @Then("User berhasil menghapus data")
    public void user_berhasil_menghapus_data() {
        driver.findElement(By.id("com.example.testingapps:id/data_view")).isDisplayed();
        driver.quit();
    }
}
