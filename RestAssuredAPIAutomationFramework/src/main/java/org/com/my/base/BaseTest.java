package org.com.my.base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.com.my.utils.PayloadGenerator;
import org.com.my.utils.TestUtils;
import org.com.my.utils.URL;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseTest {
	
	private static Logger log = LogManager.getLogger(BaseTest.class.getName());
	
	public static String doLogin(){
		Response response;
		log.info("Starting Test Case : doLogin");
		String loginPayload = PayloadGenerator.generatePayLoadString("ProdLogin.json");
		
		String endPointURI = URL.getEndPoint("/pfj-mypilot/api/v1/auth/login");
		response = RESTCalls.POSTRequest(endPointURI, loginPayload);
		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResposeString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);
		String Token = jsonRes.getString("Token.value");
		log.info(" ProdLogin Token : " + Token);
		return Token;
	}

}
