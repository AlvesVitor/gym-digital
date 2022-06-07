package me.dio.academia.digital.exception;

import me.dio.academia.digital.exception.enums.ErrorMessagesEnum;

@SuppressWarnings("serial")
public class RegistrationNotFoundException extends DefaultException {
    
    @Override
    public ErrorResponse getErrorResponse() {
        return ErrorMessagesEnum.REGISTRATION_NOTFOUND;
    }
}
