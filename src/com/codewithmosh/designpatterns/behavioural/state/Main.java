package com.codewithmosh.designpatterns.behavioural.state;


//state pattern is to be used ONLY in cases where same lines of codes are getting repetitive -
// if case is for only 1-2 blocks then DON'T ABUSE DESIGN PATTERNS
public class Main {

    private static boolean isrunning;
    public static void main(String[] args) {
        System.out.println(isrunning);
        Canvas canvas = new Canvas(new PencilTool());
        canvas.mouseDown();

        /*CanvasNA canvasNA = new CanvasNA();
        canvasNA.setCurrentTool(ToolType.PENCIL);
        canvasNA.mouseDown();
        canvasNA.mouseUp();*/

    }
}
