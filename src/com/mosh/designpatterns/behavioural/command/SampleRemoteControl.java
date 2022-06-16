package com.mosh.designpatterns.behavioural.command;

public class SampleRemoteControl {
    Command command;
    public SampleRemoteControl(){

    }

    public SampleRemoteControl(Command command){
        this.command=command;
    }

    public void onButtonPress(){
        command.execute();
    }

    public void offButtonPress(){
        command.undo();
    }
}
