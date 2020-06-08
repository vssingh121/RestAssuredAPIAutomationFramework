package org.com.my.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class TestUtils {
	
	private static Logger log = LogManager.getLogger(TestUtils.class.getName());
	
	public static String getResposeString(io.restassured.response.Response response){
		log.info("Converting Response to String");
		String strResponse = response.getBody().asString();
		log.debug(strResponse);
		return strResponse;
	}
	
	public static JsonPath jsonParser(String response){
		log.info("Parsing String Response to JSON");
		JsonPath jsonResponse = new JsonPath(response);
		log.debug(jsonResponse);
		return jsonResponse;
	}
	

	/*public static XmlPath xmlParser(String response){
		log.info("Parsing String Response to XML");
		XmlPath xmlResponse = new XmlPath(response);
		log.debug(xmlResponse);
		return xmlResponse;
	}
	*/
	public static int getStatusCode(io.restassured.response.Response response){
		log.info("Getting Response Code");
		int statusCode = response.statusCode();
		log.info(statusCode);
		return statusCode;
	}
	
	public static String getStatusMessage(Response response){
		log.info("Getting Response Message");
		String responseMessage = ((ResponseOptions<io.restassured.response.Response>) response).getStatusLine();
		log.info(responseMessage);
		return responseMessage;
	}
	
	
	
	
	
	
	
}
