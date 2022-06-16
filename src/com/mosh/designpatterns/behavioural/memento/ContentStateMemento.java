package com.mosh.designpatterns.behavioural.memento;

public class ContentStateMemento {
    public ContentStateMemento(Editor editor){
        ContentHistory.saveState(editor);
    }

    public static Editor getContent() {
        return ContentHistory.getContent();
    }

    public static Editor undo() {
        return ContentHistory.undo();
    }

}
