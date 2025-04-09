package com.educative.designpatterns.behavioral.chainofresponsibility;

public abstract class AbstractHandler implements ErrorHandler {

    private AbstractHandler next;

    public AbstractHandler(AbstractHandler next){
        this.next=next;
    }
    public void setNext(AbstractHandler next) {
        this.next = next;
    }
    @Override
    public void handleRequest(ErrorCode errorCode){
        if(next!=null){
            next.handleRequest(errorCode);
        }else {
            System.out.println("CRASHED !!");
        }

    }


}
