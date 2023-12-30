package com.honeycomb.Exceptions;

import com.honeycomb.Responses.ApiResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.dao.DataIntegrityViolationException;

//  This annotation indicates that this class provides global exception handling for your REST controllers.
@RestControllerAdvice
public class GlobalExceptionHandler {

    //  @ExceptionHandler(ResourceNotFoundException.class)
//  This method is annotated with @ExceptionHandler to handle a specific type of exception, which is ResourceNotFoundException.
//  When this exception is thrown, this method will be invoked to generate a response.

    //   handlerResourceNotFoundException(ResourceNotFoundException ex)
//   This method is responsible for handling the ResourceNotFoundException.
//   It creates an ApiResponse object with an appropriate message, sets the success status to true, and sets the HTTP status to NOT_FOUND (404).
//   It then returns a ResponseEntity with the created ApiResponse object and the HTTP status.
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(false).status(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse> handleApiException(ApiException exception) {
        String message = exception.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(false).status(HttpStatus.BAD_REQUEST).build();

        return new ResponseEntity<ApiResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse> handlerDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String message = "";
        Throwable rootCause = ex.getRootCause();
        if (rootCause != null) {
            message += rootCause.getMessage();
        }

        ApiResponse response = ApiResponse.builder().message(message).success(false).status(HttpStatus.CONFLICT).build();

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<ApiResponse> handleSignatureException(SignatureException ex) {
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(false).status(HttpStatus.FORBIDDEN).build();

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ApiResponse> handleExpiredJwtException(ExpiredJwtException ex) {
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(false).status(HttpStatus.FORBIDDEN).build();

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

}
