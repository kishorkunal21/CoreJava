package com.codewithmosh.designpatterns.behavioural.command;

public class MainGate implements Gate {

    @Override
    public void open() {
        System.out.println("Main gate :: Open");
    }

    @Override
    public void close() {
        System.out.println("Main gate :: Closed");
    }
}
