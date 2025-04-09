package com.educative.designpatterns.behavioral.chainofresponsibility;

public class Main {
    public static void main(String[] args) {
        //set up chain like - fire -> fuel -> null
        AbstractHandler lowFuelErrorHandler = new LowFuelErrorHandler(null);
        FireErrorHandler fireErrorHandler = new FireErrorHandler(lowFuelErrorHandler);

        //creating request for low fuel
        fireErrorHandler.handleRequest(ErrorCode.LOW_FUEL_REQUEST);
    }
}
