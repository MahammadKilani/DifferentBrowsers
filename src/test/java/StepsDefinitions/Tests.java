package StepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static StepsDefinitions.Drivers.softAssert;
import static StepsDefinitions.Drivers.webDriver;

public class Tests {

    int sleep = 500;

    @And("Navigates to HomePage URL")
    public void NavigateToHome(){
        webDriver.manage().window().maximize();
        webDriver.get("C:\\Users\\Adam\\Desktop\\MockSite\\HomePage.html");
    }

    @And("Clicks on First Page")
    public void clicksOnFirstPage() {
        String actual = webDriver.findElement(By.id("title")).getText();
        String expected = "HOME PAGE";
        softAssert.assertTrue(actual.contains(expected), "Home Fail");
        webDriver.findElement(By.xpath("/html/body/a")).click();
    }

    @And("Clicks on Second Page")
    public void clicksOnSecondPage() {
        String actual = webDriver.findElement(By.id("title")).getText();
        String expected = "FIRST PAGE";
        softAssert.assertTrue(actual.contains(expected), "First Fail");
        webDriver.findElement(By.xpath("/html/body/a")).click();
    }

    @Then("He could see the Name in Every Page")
    public void nameInEveryPage() {
        String actual = webDriver.findElement(By.id("title")).getText();
        String expected = "SECOND PAGE";
        softAssert.assertTrue(actual.contains(expected), "Second Fail");
        softAssert.assertAll("SomeOne Failed");
    }

}
