package com.blagovestkabov.productservice.exception;

import lombok.Data;

@Data
public class ProductException extends RuntimeException {
    private String errorCode;

    public ProductException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
