import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class mobile {
    public static AndroidDriver driver; //inisiasi android driver untuk appium
    public static DesiredCapabilities capabilities; //inisiasi desired capabilities
    public static String baseUrl = "http://127.0.0.1:4723"; //baseUrl mobile untuk appium v2

    @Test
    public void main() throws MalformedURLException{
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "sdk_gphone_x86");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platfromVersion", "11.0");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", System.getProperty("user.dir")+"/src/test/java/apk/testing-app.apk"); //set apk file directory
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoAcceptAlerts", true);

        URL url = new URL(baseUrl);
        driver = new AndroidDriver(url,capabilities); //open app

        //waiting
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //proses flow
        driver.findElement(By.id("com.example.testingapps:id/user")).sendKeys("user");
        driver.findElement(By.id("com.example.testingapps:id/sandi")).sendKeys("user123");
        driver.findElement(By.id("com.example.testingapps:id/btnlogin")).click();
        driver.findElement(By.id("com.example.testingapps:id/btnIsi")).isDisplayed();

        Random rand = new Random();
        int userRand = rand.nextInt(10000);

        var el5 = driver.findElement(AppiumBy.id("com.example.testingapps:id/btnIsi"));
        el5.click();
        var el6 = driver.findElement(AppiumBy.id("com.example.testingapps:id/nama"));
        el6.sendKeys("test"+userRand);
        var el7 = driver.findElement(AppiumBy.id("com.example.testingapps:id/notelp"));
        el7.sendKeys("021454565");
        var el8 = driver.findElement(AppiumBy.id("com.example.testingapps:id/email"));
        el8.sendKeys("test"+userRand+"@test.com");
        var el9 = driver.findElement(AppiumBy.id("com.example.testingapps:id/alamat"));
        el9.sendKeys("jl. mawar");
        var el10 = driver.findElement(AppiumBy.id("com.example.testingapps:id/kodepos"));
        el10.sendKeys("12403");
        var el11 = driver.findElement(AppiumBy.id("com.example.testingapps:id/jk_lk"));
        el11.click();
        var el12 = driver.findElement(AppiumBy.id("com.example.testingapps:id/btnSubmit"));
        el12.click();
        // WebElement element = driver.findElement(By.id("android:id/text1"));
        // new Actions(driver).clickAndHold(element).perform();

        // //waiting
        // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // driver.findElement(By.id("com.example.testingapps:id/button_edit_data")).click();
        // driver.findElement(By.id("com.example.testingapps:id/btnBatal")).click();

        // new Actions(driver).clickAndHold(element).perform();
        // //waiting
        // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        // driver.findElement(By.id("com.example.testingapps:id/button_delete_data")).click();


        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var tapPoint = new Point(187, 575);
        var tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
            PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofSeconds(5)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.id("com.example.testingapps:id/button_edit_data")).click();
        driver.findElement(By.id("com.example.testingapps:id/btnBatal")).click();

        driver.perform(Arrays.asList(tap));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("com.example.testingapps:id/button_delete_data")).click();

        //close
        //driver.quit();
    }
}
