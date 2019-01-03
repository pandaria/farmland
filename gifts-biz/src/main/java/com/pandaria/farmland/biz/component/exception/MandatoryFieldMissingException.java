package com.pandaria.farmland.biz.component.exception;

public class MandatoryFieldMissingException extends RuntimeException {
    private String missedFieldName;

    public MandatoryFieldMissingException(String missedFieldName) {
        this.missedFieldName = missedFieldName;
    }

    @Override
    public String getMessage() {
        return String.format("%s字段需要填写!", missedFieldName);
    }
}
