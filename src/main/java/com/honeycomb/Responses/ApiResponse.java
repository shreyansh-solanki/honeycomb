package com.honeycomb.Responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    //  It holds a message associated with the response
    private String message;

    //  It is a success status of the API operation
    private boolean success;

    //  It represents the HTTP status code that corresponds to the response
    private HttpStatus status;
}

