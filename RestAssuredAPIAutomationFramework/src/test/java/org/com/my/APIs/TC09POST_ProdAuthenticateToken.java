package org.com.my.APIs;

import static io.restassured.RestAssured.given;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.com.my.base.BaseAssertion;
import org.com.my.base.RESTCalls;
import org.com.my.utils.PayloadGenerator;
import org.com.my.utils.URL;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC09POST_ProdAuthenticateToken {

	//private String sessionID;
		Response response;

		private static Logger log = LogManager.getLogger(TC09POST_ProdAuthenticateToken.class.getName());

		//@BeforeMethod
		//public void setUp() {
			//sessionID = BaseTest.doLogin();
		//}

		@Test
		public void ProdAuthenticateToken () {
			log.info("Starting Create Issue Test");
			String URI = URL.getEndPoint("/pfj-digital-authprovider/api/AuthenticateToken");
			String createIssuePayLaod = PayloadGenerator.generatePayLoadString("ProdAuthenticateToken.json");
		
			
			response = RESTCalls.POSTRequest(URI,createIssuePayLaod);
			String strResponse = response.getBody().asString();
			Reporter.log(URI);
			Reporter.log("\n");
			Reporter.log(strResponse);
			
			BaseAssertion.verifyStatusCode(response, 200);
			/*Response response=given().
					body(createIssuePayLaod).
			when().
			then().
					extract().response1();
			String response1 = response.asString();
					System.out.println(response1);*/
			
			
		}}
