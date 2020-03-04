package com.test.step.definitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
//		features = {"src/test/resources/features/LoginClaro.feature"},
		features = {"src/test/resources/features/LoginSisactAvatar.feature"},
		glue = {"com.test.step.definitions"},
		plugin = {"pretty","json:target/cucumber-reports/cucumber.json"}
		)
public class ClaroRunner {

}
