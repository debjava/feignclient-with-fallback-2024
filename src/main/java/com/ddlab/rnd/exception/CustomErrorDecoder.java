package com.ddlab.rnd.exception;

import org.springframework.http.HttpStatus;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
	
	@Override
    public Exception decode(String methodKey, Response response) {
      String requestUrl = response.request().url();
      Response.Body responseBody = response.body();
      HttpStatus responseStatus = HttpStatus.valueOf(response.status());
      
    System.out.println("requestUrl---->"+requestUrl);
    System.out.println("responseBody---->"+responseBody);
    System.out.println("responseStatus---->"+responseStatus);
      
        switch (response.status()) {
            case 400:
                // Handle 400 Bad Request
                return new BadRequestException("Bad Request");
            case 404:
                // Handle 404 Not Found
                return new NotFoundException("Not Found");
            case 500:
                // Handle 500 Internal Server Error
                return new InternalServerErrorException("Internal Server Error");
            default:
                return new Exception("Generic error");
        }
    }

//    @Override
//    public Exception decode(String methodKey, Response response) {
//        String requestUrl = response.request().url();
//        Response.Body responseBody = response.body();
//        HttpStatus responseStatus = HttpStatus.valueOf(response.status());
//        
//        System.out.println("requestUrl---->"+requestUrl);
//        System.out.println("responseBody---->"+responseBody);
//        System.out.println("responseStatus---->"+responseStatus);
//
//        if (responseStatus.is5xxServerError()) {
//        	return new InternalServerErrorException("Internal Server Error");
////        	return new Exception("500 Generic exception");
////            return new RestApiServerException(requestUrl, responseBody);
//        } else if (responseStatus.is4xxClientError()) {
//        	return new Exception("400 Generic exception");
////            return new RestApiClientException(requestUrl, responseBody);
//        } else {
//            return new Exception("Generic exception");
//        }
//    }
}