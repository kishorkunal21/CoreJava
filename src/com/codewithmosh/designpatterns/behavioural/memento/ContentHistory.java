package com.codewithmosh.designpatterns.behavioural.memento;

import java.util.Stack;

public class ContentHistory {
    private static Stack<Editor> stateStack = new Stack<>();

    static void saveState(Editor content){
        System.out.println("stateStack-----------"+stateStack.size());
        if(stateStack.size()>0){
            for(Editor editor:stateStack){
                System.out.println(editor);
            }
        }
        stateStack.push(content);
    }

    static Editor undo(){
        if(stateStack.size()>0)
            return stateStack.pop();
        else
            return null;
    }

    static Editor getContent(){
        System.out.println("stateStack.size()::"+stateStack.size());
        return stateStack.peek();
    }

}
