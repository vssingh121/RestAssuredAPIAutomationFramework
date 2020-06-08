package org.com.my.base;

import java.util.HashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;




import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class RESTCalls {
	/*
	 * This call will be resposible to fire requests
	 */

	private static Logger log = LogManager.getLogger(RESTCalls.class.getName());
	public static Response GETRequest(String uRI) {
		
		log.info("Inside GETRequest call");
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Client_id","49847de1f7784f2e82ee6dd7c66fa419");
		requestSpecification.header("Client_Secret","08f8983763364bB68d8E9779108ffb55");
		requestSpecification.header("Authorization","Loyalty pfjpilot+300@gmail.com:4fdda02872c8a0953fbcb0dc7a22e02c552a6cd2c2dc1b25c157e462458c06bb");
		Response response = requestSpecification.get(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response POSTRequest(String uRI, String strJSON) {
		log.info("Inside POSTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Client_id","49847de1f7784f2e82ee6dd7c66fa419");
		requestSpecification.header("Client_Secret","08f8983763364bB68d8E9779108ffb55");
		requestSpecification.header("Authorization","Loyalty pfjpilot+300@gmail.com:93c81971da5e21599dc53a24b171761e14e22b44f3f75985e6806bc82551c50b");
		
		
		Response response = requestSpecification.post(uRI);
	
		log.debug(requestSpecification.log().all());
		
		
		return response;
	}
	
	public static Response POSTRequest(String uRI, String strJSON, String sessionID) {
		log.info("Inside POSTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("cookie", "JSESSIONID=" + sessionID+"");
		Response response = requestSpecification.post(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}
	

	public static Response PUTRequest(String uRI, String strJSON) {
		log.info("Inside PUTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response DELETERequest(String uRI, String strJSON) {
		log.info("Inside DELETERequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

}
