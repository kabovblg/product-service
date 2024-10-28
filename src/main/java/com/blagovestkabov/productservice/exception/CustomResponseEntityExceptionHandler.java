package com.blagovestkabov.productservice.exception;

import com.blagovestkabov.productservice.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorResponse> handleProductServiceException(ProductException productException) {
        return new ResponseEntity<>(new ErrorResponse(productException.getMessage(), productException.getErrorCode()), HttpStatus.NOT_FOUND);
    }
}
