package com.algaworks.algalog.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.algaworks.algalog.domain.exception.DomainException;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  private MessageSource messageSource;

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    List<Error.Field> fields = new ArrayList<>();
    ex.getBindingResult().getAllErrors().stream().forEach(objectError -> {
      String name = ((FieldError) objectError).getField();
      String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
      fields.add(new Error.Field(name, message));
    });
    Error error = new Error();
    error.setStatus(status.value());
    error.setTimestamp(OffsetDateTime.now());
    error.setTitle("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente");
    error.setFields(fields);
    return handleExceptionInternal(ex, error, headers, status, request);
  }

  @ExceptionHandler(DomainException.class)
  ResponseEntity<Object> handleDomainException(DomainException ex, WebRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    Error error = new Error();
    error.setStatus(status.value());
    error.setTimestamp(OffsetDateTime.now());
    error.setTitle(ex.getMessage());
    return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
  }

}
