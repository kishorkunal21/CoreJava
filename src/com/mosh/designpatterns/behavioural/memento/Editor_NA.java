package com.mosh.designpatterns.behavioural.memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//memento patterns is to implement UNDO mechanism
//Inefficient SOLUTION -
public class Editor_NA {
    private String text;
    Stack<String> stringStack = new Stack<>();

    public String getText() {
        StringBuilder content =new StringBuilder();
        for(String s:stringStack){
            content.append(s+"\n");
        }
        return content.toString();
    }

    public void setText(String text) {
        this.text = text;
        stringStack.push(this.text);
    }

    void undo(){
        stringStack.pop();
    }
}
