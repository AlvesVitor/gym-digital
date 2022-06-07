package me.dio.academia.digital.exception;

import me.dio.academia.digital.exception.enums.ErrorMessagesEnum;

@SuppressWarnings("serial")
public class EvaluationPhysicalNotFoundException extends DefaultException {

    @Override
    public ErrorResponse getErrorResponse() {
        return ErrorMessagesEnum.EVALUATION_PHYSICAL_NOTFOUND;
    }
}
