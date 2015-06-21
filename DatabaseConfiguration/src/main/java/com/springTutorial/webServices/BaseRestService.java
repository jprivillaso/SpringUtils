package com.springTutorial.webServices;

import org.springframework.http.HttpHeaders;

public class BaseRestService {

	private static final String CORS_ALLOWED_ORIGIN = "*";

	public static HttpHeaders getAllowOriginHeaders() {
		
		//--- Allow CORS
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Access-Control-Allow-Origin", CORS_ALLOWED_ORIGIN);

	    return responseHeaders;
	    
	}
	
}