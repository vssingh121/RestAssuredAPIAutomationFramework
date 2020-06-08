package org.com.my.APIs;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.com.my.base.BaseTest;
import org.com.my.base.RESTCalls;
import org.com.my.utils.PayloadGenerator;
import org.com.my.utils.TestUtils;
import org.com.my.utils.URL;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginTest {

	Response response;
		
		//private static Logger log = LogManager.getLogger(BaseTest.class.getName());
		@Test
		public void doLogin(){
			//Response response;
			//log.info("Starting Test Case : doLogin");
			String loginPayload = PayloadGenerator.generatePayLoadString("ProdLogin.json");
			
			String endPointURI = URL.getEndPoint("/v1/auth/login");
			response = RESTCalls.POSTRequest(endPointURI, loginPayload);
			//log.info(response.getBody().asString());
			String strResponse = response.getBody().asString();
			
			System.out.println("******************Response JSON************************");
			//JsonPath jsonRes = TestUtils.jsonParser(strResponse);
			//String Token = jsonRes.getString("Token.value");
			//log.info(" ProdLogin Token : " + Token);
			System.out.println(strResponse);
			JsonPath jsonRes = new JsonPath(strResponse);
			String loginResult=jsonRes.getString("session.value");
			
			System.out.println(loginResult);
			
			
		}
}
