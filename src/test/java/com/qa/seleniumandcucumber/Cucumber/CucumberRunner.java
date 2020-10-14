package com.qa.seleniumandcucumber.Cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
plugin = {"pretty","html:target/reports/htmlreports"},
monochrome = true,
tags={"@mytag"})
public class CucumberRunner {
}
