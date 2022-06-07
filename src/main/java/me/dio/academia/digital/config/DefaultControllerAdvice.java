
package me.dio.academia.digital.config;

import me.dio.academia.digital.config.dto.ErrorResponseDto;
import me.dio.academia.digital.exception.DefaultException;
import me.dio.academia.digital.exception.ErrorResponse;
import me.dio.academia.digital.exception.GenericException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@SuppressWarnings("rawtypes")
public class DefaultControllerAdvice {

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseDto> handle(RuntimeException exception) {
        ErrorResponse errorResponse = null;
        if (exception instanceof DefaultException) {
            DefaultException defaultException = (DefaultException) exception;
            errorResponse = defaultException.getErrorResponse();
        } else {
            errorResponse = new GenericException().getErrorResponse();
            System.out.println(exception.getMessage());
        }
        System.out.println(errorResponse);
        System.out.println(exception);
        String internalMessage = exception.getCause() != null ? exception.getCause().toString() : exception.toString();
        return ResponseEntity
                .status(errorResponse.getHttpStatus())
                .body(new ErrorResponseDto(errorResponse.getCodigo(), errorResponse.getMensagem(), internalMessage));
    }

}
