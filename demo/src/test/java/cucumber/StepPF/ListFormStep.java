package cucumber.StepPF;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import config.env;
import cucumber.mobilePF.ListFormPF;
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
    }
    
    @When("User klik salah satu List")
    public void user_klik_salah_satu_list() {
        ListFormPF listPage = new ListFormPF(driver);
        listPage.pilihData();
    }
    @When("User isi ulang data")
    public void user_isi_ulang_data() {
        ListFormPF listPage = new ListFormPF(driver);
        listPage.isiData("test ubah data");
    }
    @When("User klik button Ubah")
    public void user_klik_button_ubah() {
        ListFormPF listPage = new ListFormPF(driver);
        listPage.klikSubmit();
    }
    @Then("Data berhasil diubah")
    public void data_berhasil_diubah() {
        ListFormPF listPage = new ListFormPF(driver);
        listPage.verify();
    }

    @When("User klik button Batal")
    public void user_klik_button_batal() {
        ListFormPF listPage = new ListFormPF(driver);
        listPage.klikBatal();
    }
    @Then("User kembali ke page List Form")
    public void user_kembali_ke_page_list_form() {
        ListFormPF listPage = new ListFormPF(driver);
        listPage.verify();
    }

    @When("User klik button Hapus")
    public void user_klik_button_hapus() {
        ListFormPF listPage = new ListFormPF(driver);
        listPage.klikHapus();
    }

    @Then("User berhasil menghapus data")
    public void user_berhasil_menghapus_data() {
        ListFormPF listPage = new ListFormPF(driver);
        listPage.verifydel();
    }

    @Then("User melihat detail data")
    public void user_melihat_detail_data() throws InterruptedException {
        ListFormPF listPage = new ListFormPF(driver);
        listPage.lihatData();
    }
}
