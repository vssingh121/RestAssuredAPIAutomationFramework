package org.com.my.APIs;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.com.my.base.BaseAssertion;
import org.com.my.base.RESTCalls;
import org.com.my.utils.URL;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC02GET_ProdLocationsites {


//private String sessionID;
	Response response;

	private static Logger log = LogManager.getLogger(TC02GET_ProdLocationsites.class.getName());

	//@BeforeMethod
	//public void setUp() {
		//sessionID = BaseTest.doLogin();
	//}

	@Test
	public void ProdLocationsites() {
		log.info("Starting Create Issue Test");
		String URI = URL.getEndPoint("/v1/images/search");
		//String createIssuePayLaod = PayloadGenerator.generatePayLoadString("ProdLogin.json");
	
		
		response = RESTCalls.GETRequest(URI);
		String strResponse = response.getBody().asString();
		Reporter.log(URI);
		Reporter.log("\n");
		Reporter.log(strResponse);
	
		BaseAssertion.verifyStatusCode(response, 200);
		
		
	}}