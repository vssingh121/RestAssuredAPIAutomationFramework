package org.com.my.APIs;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.com.my.base.BaseAssertion;
import org.com.my.base.RESTCalls;
import org.com.my.utils.PayloadGenerator;
import org.com.my.utils.TestUtils;
import org.com.my.utils.URL;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC01_POSTLogin {

	

		//private String sessionID;
			Response response;

			private static Logger log = LogManager.getLogger(TC01_POSTLogin.class.getName());

			//@BeforeMethod
			//public void setUp() {
				//sessionID = BaseTest.doLogin();
			//}

			@Test
			public void POSTLogin () {
				log.info("Starting Create Issue Test");
				String URI = URL.getEndPoint("/pfj-mypilot/api/v1/auth/login");
				String createIssuePayLaod = PayloadGenerator.generatePayLoadString("ProdLogin.json");
			
				
				response = RESTCalls.POSTRequest(URI,createIssuePayLaod);
				//String strResponse = response.getBody().asString();
				//System.out.println(strResponse);
				log.info(response.getBody().asString());
				String strResponse = TestUtils.getResposeString(response);
				JsonPath jsonRes = TestUtils.jsonParser(strResponse);
				String Token = jsonRes.getString("Token.value");
				log.info(" ProdLogin Token : " + Token);
				
				Reporter.log(URI);
				Reporter.log("\n");
				Reporter.log(strResponse);
				
				//System.out.println(Token);
				
				BaseAssertion.verifyStatusCode(response, 200);
				
				
			}}