package com.mosh.designpatterns.behavioural.command;

// Building a UI application -  to have different Controls which will be used by developers
// Button - code on click depends on where we're going to use the Button
// command pattern solves this problem
public class Main {
    public static void main(String[] args) {
        Light bedroomLight = new BedroomLight();
        SampleRemoteControl sampleRemoteControl = new SampleRemoteControl(new LightOnCommand(bedroomLight));
        sampleRemoteControl.onButtonPress();

        sampleRemoteControl = new SampleRemoteControl( new DoorOpenCommand(new MainGate()));
        sampleRemoteControl.onButtonPress();

        sampleRemoteControl = new SampleRemoteControl( new DoorOpenCommand(new MainGate()));
        sampleRemoteControl.offButtonPress();

        sampleRemoteControl= new SampleRemoteControl(new LightOnCommand(new KitchenLight()));
        sampleRemoteControl.onButtonPress();

        sampleRemoteControl= new SampleRemoteControl(new LightOnCommand(new KitchenLight()));
        sampleRemoteControl.offButtonPress();

        sampleRemoteControl= new SampleRemoteControl(new LightOnCommand(new KitchenLight()));
        sampleRemoteControl.offButtonPress();


    }


}
