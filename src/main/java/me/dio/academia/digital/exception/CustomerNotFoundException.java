package me.dio.academia.digital.exception;

import me.dio.academia.digital.exception.enums.ErrorMessagesEnum;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends DefaultException {

    @Override
    public ErrorResponse getErrorResponse() {
        return ErrorMessagesEnum.CUSTOMER_NOTFOUND;
    }
}
