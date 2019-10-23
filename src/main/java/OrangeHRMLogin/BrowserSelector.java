package OrangeHRMLogin;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;


public class BrowserSelector extends Utils {
    public static LoadProp loadProp = new LoadProp();
    public static final String SAUCE_USERNAME =loadProp.getProperties("sauceUserName");
    public static final String SAUCE_ACCESS_KEY = loadProp.getProperties("sauceAccessKey");
    public static final String URL = "http://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + "@//ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    public static final boolean SAUCE_LAB = Boolean.parseBoolean(System.getProperty("Sauce"));
    public static final String browser = System.getProperty("browser");

    public void setUpBrowser() {
        //if sauce lab is true.....
        if (SAUCE_LAB)
        //if saucelab is true ...........
        {
            System.out.println("Running in saucelab : " + browser);

            if (browser.equalsIgnoreCase("Firefox")) {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "37.0");
                browserOptions.setCapability("sauce:options", sauceOptions);


                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

            } else if (browser.equalsIgnoreCase("chrome")) {

                MutableCapabilities sauceOptions = new MutableCapabilities();

                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setExperimentalOption("w3c", true);
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "65.0");
                browserOptions.setCapability("sauce:options", sauceOptions);

                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("platform", "VISTA");
                caps.setCapability("version", "61.0");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }


            } else if (browser.equalsIgnoreCase("edge")) {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "18.17763");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }

            else
            {

                System.out.println("Browser name is wrong: " + browser);
            }

        }
    }
}
