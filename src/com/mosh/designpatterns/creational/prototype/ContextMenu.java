package com.mosh.designpatterns.creational.prototype;

public class ContextMenu {

    /* BAD OPTION because -
        --------------------------------------------------------------------------------------
        Violates the SOLID Design principle -
        Class is not open for extension and Closed for modification
        Reason - ContextMenu is dependent on CIRCLE
                 ContextMenu is not open for extension - meaning if I need to add Square shape -
                 code change will be required here
        --------------------------------------------------------------------------------------
    public void duplicate(Component component){
        if(component instanceof Circle){
            Circle source = ((Circle) component);
            System.out.println("Source hashcode :: "+ source.hashCode()+" Radius :: "+  + source.getRadius());
            Circle target = new Circle();
            target.setRadius(source.getRadius());
            System.out.println("Target hashcode :: "+ target.hashCode()+" Radius :: "+  + target.getRadius());
        }
    }

    SOLUTION - >>>>>>>>>
    */
    public Component duplicate(Component component){
        Component duplicate = component.duplicate();
        return duplicate;
    }


}
