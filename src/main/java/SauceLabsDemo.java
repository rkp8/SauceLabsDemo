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

    public static final String USERNAME = "Your User Name";
    public static final String ACCESS_KEY = "Your Access Key";
    public static final String URL1 = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com/wd/hub";

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        MutableCapabilities sauceOptions = new MutableCapabilities();

        SafariOptions browserOptions = new SafariOptions();
        browserOptions.setCapability("platformName", "macOS 10.14");
        browserOptions.setCapability("browserVersion", "latest");
        browserOptions.setCapability("sauce:options", sauceOptions);

        WebDriver driver = new RemoteWebDriver(new URL(URL1), browserOptions);


        /*System.setProperty("webdriver.chrome.driver","/Users/riken/Saucelabs/chromedriver");
        WebDriver driver = new ChromeDriver();
*/
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Group 9 SauceLabs Demo");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
        System.out.println(driver.getTitle());

        Thread.sleep(500);

        /*driver.get("https://saucelabs.com/test/guinea-pig");
        System.out.println("title of page is: " + driver.getTitle());*/

        driver.quit();

        System.out.println("Tests Completed");



    }





}
