package com.educative.designpatterns.behavioral.chainofresponsibility;

public class CrashErrorHandler extends AbstractHandler{

    public CrashErrorHandler(AbstractHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(ErrorCode errorCode) {
        if(errorCode.getErrorCode()==ErrorCode.LOW_FUEL_REQUEST.getErrorCode()){
            System.out.println("HANDLING LOW FUEL ERROR !!!!! ");
        }
        else{
            System.out.println("FORWARDING TO NEXT HANDLER...");
            super.handleRequest(errorCode);
        }
    }
}
