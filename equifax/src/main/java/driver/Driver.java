package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;

public class Driver {
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    public static WebDriver webDriver;
    private static File root = new File("Drivers");

    public static void resolveDriver(String navegador, String nameDriver, String url) {
        File driverPath;

        if ("Chrome".equals(navegador)) {
            System.out.println("Se selecciona Chrome");
            driverPath = new File(root, nameDriver);
            System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath());
            ChromeOptions options = new ChromeOptions();
            webDriver = new ChromeDriver(options);
            capabilities.setBrowserName("Chrome");
            webDriver.manage().window().maximize();
        } else if ("Firefox".equals(navegador)) {//
            return;
        }

        webDriver.get(url);
    }

    public static WebDriver getDriverWeb() {
        return webDriver;
    }

    public static void quitDriverWeb() {
        getDriverWeb().quit();
    }
}
