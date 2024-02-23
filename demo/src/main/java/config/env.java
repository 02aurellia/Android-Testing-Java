package config;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class env {
    protected static AndroidDriver driver; //inisiasi android driver untuk appium
    protected static DesiredCapabilities capabilities; //inisiasi desired capabilities
    protected static String baseUrl = "http://127.0.0.1:4723"; //baseUrl mobile untuk appium v2
}
