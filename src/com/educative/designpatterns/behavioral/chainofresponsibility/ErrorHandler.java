package com.educative.designpatterns.behavioral.chainofresponsibility;

public interface ErrorHandler {

    void handleRequest(ErrorCode errorCode);

}
