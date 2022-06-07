package me.dio.academia.digital.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public interface ErrorResponse {

    HttpStatus getHttpStatus();

    String getMensagem();

    String getCodigo();

}
