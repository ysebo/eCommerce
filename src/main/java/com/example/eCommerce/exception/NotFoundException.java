

package com.example.eCommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final String message;
    @Getter
    private HttpStatus httpStatus = null;

    public NotFoundException(String message) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

}