package com.qa.seleniumandcucumber.Cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Stepdefs {
    private String today;
    private String actualAnswer;
    WebDriver driver;
    private WebElement target;


//
//    @Given("^today is Sunday$")
//    public void today_is_Sunday() {
//        today = "Sunday";
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
//        driver = new ChromeDriver(chromeCfg());
//        driver.get("https://www.google.co.uk");
//        driver.manage().deleteAllCookies();
//
//    }
//
//    @When("^I ask whether it's Friday yet$")
//    public void i_ask_whether_it_s_Friday_yet() {
//        actualAnswer = IsItFriday.isItFriday(today);
//    }
//
//
//    @Then("^I should be told \"([^\"]*)\"$")
//    public void iShouldBeTold(String expectedAnswer)  {
//        assertEquals(expectedAnswer, actualAnswer);
//    }

    @Given("^we can open google$")
    public void weCanOpenGoogle() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver(chromeCfg());
        driver.get("https://www.google.co.uk");
        driver.manage().deleteAllCookies();
    }

    @When("^we search for kittens$")
    public void weSearchForKittens() {
        //driver.findElement(By.xpath());
        
    }

    @Then("^google will return us images of kittens$")
    public void googleWillReturnUsImagesOfKittens() {
        
    }

    @Given("^we can open re-open google$")
    public void weCanOpenReOpenGoogle() {
        
    }

    @When("^we search for puppies$")
    public void weSearchForPuppies() {
        
    }

    @Then("^google will return us images of \"([^\"]*)\"$")
    public void googleWillReturnUsImagesOf(String arg0){
    }

    public static ChromeOptions chromeCfg() {
        Map<String, Object> prefs = new HashMap<String, Object>();
        ChromeOptions cOptions = new ChromeOptions();

        // Settings
        prefs.put("profile.default_content_setting_values.cookies", 2);
        prefs.put("network.cookie.cookieBehavior", 2);
        prefs.put("profile.block_third_party_cookies", true);
//        Create ChromeOptions to disable Cookies pop-up
        cOptions.setExperimentalOption("prefs", prefs);
//      cOptions.setHeadless(true);

        return cOptions;
    }
}
