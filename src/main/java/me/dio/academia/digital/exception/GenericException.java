package me.dio.academia.digital.exception;

import me.dio.academia.digital.exception.enums.ErrorMessagesEnum;

@SuppressWarnings("serial")
public class GenericException extends DefaultException {

    @Override
    public ErrorResponse getErrorResponse() {
        return ErrorMessagesEnum.GENERIC_ERROR;
    }

}
