package com.liquors.file.shared.exception.base;

import com.liquors.file.shared.exception.error.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequestMapping(MediaType.APPLICATION_JSON_VALUE)
public class BaseExceptionResolver {

  @ExceptionHandler(BaseException.class)
  public ResponseEntity<ErrorResponse> errorHandler(BaseException exception) {
    return new ResponseEntity<>(ErrorResponse.builder()
        .status(exception.getStatus().value())
        .code(exception.getCode())
        .message(exception.getMessage())
        .date(exception.getDate().toString())
        .build(),
        HttpStatus.valueOf(exception.getStatus().value()));
  }
}