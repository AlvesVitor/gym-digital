package me.dio.academia.digital.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import me.dio.academia.digital.exception.ErrorResponse;
import org.springframework.http.HttpStatus;

@Getter
@ToString
@AllArgsConstructor
public enum ErrorMessagesEnum implements ErrorResponse {

    // erros genericos
    GENERIC_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "GEN001", "Generic error"),
    CUSTOMER_NOTFOUND(HttpStatus.NOT_FOUND, "CUST001", "Customer not found"),
    REGISTRATION_NOTFOUND(HttpStatus.NOT_FOUND, "REG001", "Registration not found"),
    EVALUATION_PHYSICAL_NOTFOUND(HttpStatus.NOT_FOUND, "EVP001", "Evaluation Physical not found");

    private final HttpStatus httpStatus;
    private final String codigo;
    private final String mensagem;
}
