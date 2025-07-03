package com.kodat.of.melasoft.handler;


import com.kodat.of.melasoft.exception.InvalidXmlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(InvalidXmlException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidXmlException(InvalidXmlException e) {
        LOGGER.error("Unexpected error occurred: {}", e.getMessage(), e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        ExceptionResponse.builder()
                                .businessErrorCode(BusinessErrorCodes.VALIDATION_ERROR.getCode())
                                .businessErrorDescription(BusinessErrorCodes.VALIDATION_ERROR.getDescription())
                                .error(e.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception e) {
        LOGGER.error("Unexpected error occurred: {}", e.getMessage(), e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        ExceptionResponse.builder()
                                .businessErrorCode(BusinessErrorCodes.INTERNAL_SERVER_ERROR.getCode())
                                .businessErrorDescription(BusinessErrorCodes.INTERNAL_SERVER_ERROR.getDescription())
                                .errors(Map.of("message",e.getMessage()))
                                .build()
                );
    }
}
