package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions
(features=".//Features/",
glue="stepDefinitions",
dryRun=false,
monochrome=true,
plugin= {"pretty","html:test1-output"},
tags= {"@sanity,@regression"}
		)

public class TestRun {

}
