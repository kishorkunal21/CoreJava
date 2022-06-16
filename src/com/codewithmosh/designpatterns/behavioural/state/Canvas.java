package com.codewithmosh.designpatterns.behavioural.state;

//state pattern is to remove redundancy of repetitive code
public class Canvas {
    Tools tools;
    public Canvas(Tools tools){
        this.tools = tools;
    }
    public void mouseDown(){
        System.out.println("mouse down for - ");
        tools.draw();
    }
    public void mouseUp(){
        System.out.println("mouse up for - ");
        tools.draw();
    }




}
