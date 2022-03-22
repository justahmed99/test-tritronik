package com.example.demo.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataResponse<Any> {
    private String message = "";
    private Any data = null;

    public DataResponse(String message, Any data) {
        this.message = message;
        this.data = data;
    }

    public DataResponse() {}
}
