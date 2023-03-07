package iti.jets.marketplace.utils;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;


public class ResponseViewModel {
    private Map<String, Object> responseBody = new HashMap<>();
    
    public void setResponseBody(String massage, HttpStatus status, Object data) {
        responseBody.put("massage", massage);
        responseBody.put("status", status);
        responseBody.put("data", data);
    }

    public Map<String, Object> getResponseBody() {
        return responseBody;
    }
}
