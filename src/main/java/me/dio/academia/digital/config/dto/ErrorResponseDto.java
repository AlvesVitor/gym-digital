package me.dio.academia.digital.config.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto {

    private String codigo;
    private String mensagem;
    private String internalMessage;

    public ErrorResponseDto(String codigo, String mensagem, String internalMessage) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.internalMessage = internalMessage;
    }

}
