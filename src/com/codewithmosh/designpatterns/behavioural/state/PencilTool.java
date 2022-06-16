package com.codewithmosh.designpatterns.behavioural.state;

public class PencilTool implements Tools{

    @Override
    public void draw() {
        System.out.println("Pencil tool in use..");
    }
}
