package com.mosh.designpatterns.behavioural.state;

public class BrushTool implements Tools{
    @Override
    public void draw() {
        System.out.println("Brush tool in use..");
    }
}
