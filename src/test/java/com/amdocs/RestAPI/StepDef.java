package com.amdocs.RestAPI;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, classes=RestApiApplication.class)
public class StepDef {
	String url;
	Double actualResult;

	@Given("A Rest calculator api {string}")
	public void a_Rest_calculator_api(String serviceURL) {
	    url = serviceURL;
	}

	@When("invoking rest api for addition")
	public void invoking_rest_api_for_addition() {
	    RestTemplate restTemplate = new RestTemplate();
	    actualResult = restTemplate.getForObject(url, Double.class);
	}

	@Then("expecting result as {int}")
	public void expecting_result_as(Integer expectedResult) {
	    assertEquals(actualResult,expectedResult, 0.01);
	}
}
