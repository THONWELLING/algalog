package com.thonwelling.api.exceptionhandler;


import com.thonwelling.api.exception.EntidadeNaoEncontradaException;
import com.thonwelling.api.exception.NegocioException;
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

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                HttpHeaders headers, HttpStatus status, WebRequest request) {

    List<Campo> campos = new ArrayList<>();

    for(ObjectError error : ex.getBindingResult().getAllErrors()) {

      String nome = ((FieldError) error).getField();
      String mensagem = error.getDefaultMessage();

      campos.add(new Campo(nome, mensagem));
    }

    Problema problema = new Problema(status.value(),
        OffsetDateTime.now(),
        "Um ou mais campos estão inválidos. Verifique e tente novamente!",
        campos);


    return handleExceptionInternal(ex, problema, headers, status, request);
  }

  @ExceptionHandler(NegocioException.class)
  public ResponseEntity<Object> handleNegocioException(NegocioException ex, WebRequest request) {

    HttpStatus status = HttpStatus.BAD_REQUEST;

    Problema problema = new Problema(status.value(),
        OffsetDateTime.now(),
        ex.getMessage());

    return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
  }

  @ExceptionHandler(EntidadeNaoEncontradaException.class)
  public ResponseEntity<Object> handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex, WebRequest request) {

    HttpStatus status = HttpStatus.NOT_FOUND;

    Problema problema = new Problema(status.value(),
        OffsetDateTime.now(),
        ex.getMessage());

    return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
  }
}
