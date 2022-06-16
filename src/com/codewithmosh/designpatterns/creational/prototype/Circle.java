package com.codewithmosh.designpatterns.creational.prototype;

public class Circle implements Component{

    private int radius;

    @Override
    public void render() {
        System.out.println("Rendering a circle of radius : "+radius);
    }

    @Override
    public Component duplicate() {
        Circle circle = new Circle();
        circle.setRadius(this.getRadius());
        return circle;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
