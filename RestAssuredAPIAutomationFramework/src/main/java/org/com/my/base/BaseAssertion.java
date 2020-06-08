package org.com.my.base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.com.my.utils.TestUtils;
import org.testng.Assert;



import io.restassured.response.Response;

public class BaseAssertion {
	private static Logger log = LogManager.getLogger(TestUtils.class.getName());
	
	public static void verifyTrue(boolean flag){
		Assert.assertTrue(flag);
	}
	
	public static void verifyFalse(boolean flag){
		Assert.assertFalse(flag);
	}

	public static void verifyStatusCode(Response response, int status){
		Assert.assertEquals(TestUtils.getStatusCode(response), status);
	}
	
	public static void verifyStatusMessage(Response response, String status){
		Assert.assertEquals(TestUtils.getStatusCode(response), status);
		
	}
}
