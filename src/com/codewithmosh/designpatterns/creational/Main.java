package com.codewithmosh.designpatterns.creational;

import com.codewithmosh.designpatterns.creational.prototype.Circle;
import com.codewithmosh.designpatterns.creational.prototype.ContextMenu;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(10);

        System.out.println("Original :: "+ circle.getRadius()+" Hashcode : "+circle.hashCode());

        ContextMenu contextMenu = new ContextMenu();
        for(int i=0;i<10;i++){
            Circle duplicate = (Circle) contextMenu.duplicate(circle);
            System.out.println("Duplicated :: "+ duplicate.getRadius() +" Hashcode : "+duplicate.hashCode());
        }

    }
}
