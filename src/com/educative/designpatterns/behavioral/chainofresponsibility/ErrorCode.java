package com.educative.designpatterns.behavioral.chainofresponsibility;

public enum ErrorCode {
    FIRE_REQUEST(1),
    LOW_FUEL_REQUEST(2);

    private int errorCode;
    ErrorCode(int errorCode) {
        this.errorCode =errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public static ErrorCode getByCode(int code){
        for(ErrorCode error:ErrorCode.values()){
            if(error.errorCode ==code)
                return error;
        }
        return null;
    }
}
