package com.codewithmosh.designpatterns.behavioural.command;

public class DoorOpenCommand implements Command{

    Gate gate;

    public DoorOpenCommand(Gate gate){
        this.gate=gate;
    }

    @Override
    public void execute() {
        open();
    }

    @Override
    public void undo() {
        gate.close();
    }

    void open(){
        gate.open();
    }
}
