package StepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

public class Drivers {
    public static WebDriver webDriver;
    public static SoftAssert softAssert;

    @When("^user opens \"(.*)\"$")
    public void startingDriver(String browser) {
        softAssert = new SoftAssert();
        switch (browser) {
            case "Google Chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
            case "Mozilla Firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\geckodriver.exe");
                webDriver = new FirefoxDriver();
                break;
            case "Microsoft Edge":
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\msedgedriver.exe");
                webDriver = new EdgeDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
    }

    @After("@RunMe")
    public void endingDriver(){
        webDriver.quit();
    }
}
