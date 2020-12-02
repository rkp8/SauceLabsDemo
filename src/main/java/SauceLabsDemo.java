import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;

public class SauceLabsDemo {

    //TODO: Fill in your SauceLabs Credentials:
    public static final String USERNAME = "Your Username";
    public static final String ACCESS_KEY = "Your Access key";


    public static final String URL1 = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com/wd/hub";


    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        //TODO: Add Browser and Platform Configuration Code using https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/:
        //------------------------------------------------------------------------------------------------------------------------
        MutableCapabilities sauceOptions = new MutableCapabilities();

        SafariOptions browserOptions = new SafariOptions();
        browserOptions.setCapability("platformName", "macOS 10.14");
        browserOptions.setCapability("browserVersion", "latest");
        browserOptions.setCapability("sauce:options", sauceOptions);
        //------------------------------------------------------------------------------------------------------------------------

        //Already Taken Care of:
        //Instantiate a new Remote webdriver and pass in the URL1 string and browserOptions object
        WebDriver driver = new RemoteWebDriver(new URL(URL1), browserOptions);

        //TODO: Add Selenium Test Code (Be sure to get rid of the older webdriver you were using):

        //Example Test for a Google Search:
        //------------------------------------------------------------------------------------------------------------------------

        //Go to google.com
        driver.get("https://google.com");

        //Print title of webpage to Console
        System.out.println(driver.getTitle());

        //Type in search query into Search box:
        driver.findElement(By.name("q")).sendKeys("Group 9 SauceLabs Demo");

        //Hits Enter to execute query
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

        //Print title of webpage to Console
        System.out.println(driver.getTitle());

        //Causes Delay in test to allow us to see the search results
        Thread.sleep(3000);

        //Ends tests
        driver.quit();

        System.out.println("Tests Completed");

        //------------------------------------------------------------------------------------------------------------------------

    }





}
