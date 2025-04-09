package com.educative.designpatterns.behavioral.chainofresponsibility;

public class FireErrorHandler extends AbstractHandler{

    public FireErrorHandler(AbstractHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(ErrorCode errorCode) {
        if(errorCode.getErrorCode()==ErrorCode.FIRE_REQUEST.getErrorCode()){
            System.out.println("HANDLING FIRE ERROR !!!!! ");
        }
        else{
            System.out.println("FORWARDING TO NEXT HANDLER...");
            super.handleRequest(errorCode);
        }
    }
}
