package com.sgr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private HttpStatus statusCode;

    private String description;

    private T data;

    public ApiResponse(T data) {
        this.data = data;
    }

    public ApiResponse(HttpStatus statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
    }

    public ApiResponse(HttpStatus statusCode, T data) {
        this.statusCode = statusCode;
        this.data = data;
    }
}
