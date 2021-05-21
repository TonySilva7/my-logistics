package com.tony.logistica.api.exceptionhandler;

import com.tony.logistica.domain.exception.DomainException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<MyErrorFields> fields = new ArrayList<>();
        log.warn("Passei por aqui....");
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String name = ((FieldError) error).getField();
            String errorMessage = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            fields.add(new MyErrorFields(name, errorMessage));
        }

        Problem problem = new Problem();
        problem.setStatus(status.value());
        problem.setTimeStamp(OffsetDateTime.now());
        problem.setTitle("One or more fields are invalid");

        problem.setFields(fields);

        return super.handleExceptionInternal(ex, problem, headers, status, request);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Object> handleDomainException(DomainException dmEx, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        Problem problem = new Problem();
        problem.setStatus(status.value());
        problem.setTimeStamp(OffsetDateTime.now());
        problem.setTitle(dmEx.getMessage());

        return handleExceptionInternal(dmEx, problem, new HttpHeaders(), status, request);
    }
}
