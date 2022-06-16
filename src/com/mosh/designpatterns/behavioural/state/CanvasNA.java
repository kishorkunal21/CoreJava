package com.mosh.designpatterns.behavioural.state;

public class CanvasNA {
    private ToolType currentTool;

    public void mouseDown(){
        System.out.println("mouse down ::");
        if(currentTool == ToolType.SELECTION){
            System.out.println("Using tool for "+ToolType.SELECTION);
        }else if(currentTool == ToolType.BRUSH){
            System.out.println("Using tool for "+ToolType.BRUSH);
        }else if(currentTool == ToolType.PENCIL){
            System.out.println("Using tool for "+ToolType.PENCIL);
        }
    }
    public void mouseUp(){
        System.out.println("mouse up ::");
        if(currentTool == ToolType.SELECTION){
            System.out.println("Using tool for "+ToolType.SELECTION);
        }else if(currentTool == ToolType.BRUSH){
            System.out.println("Using tool for "+ToolType.BRUSH);
        }else if(currentTool == ToolType.PENCIL){
            System.out.println("Using tool for "+ToolType.PENCIL);
        }
    }

    public ToolType getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(ToolType currentTool) {
        this.currentTool = currentTool;
    }

}
