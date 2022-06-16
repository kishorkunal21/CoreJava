package com.codewithmosh.designpatterns.behavioural.memento;

//SOLUTION -
public class Editor {
    private String text, heading ;

    public Editor(String text, String heading) {
        this.text = text;
        this.heading = heading;
        new ContentStateMemento(this);
    }

    public Editor undo(){
        return ContentStateMemento.undo();
    }

    public void setText(String text) {
        String header_prev = ContentStateMemento.getContent().heading;
        new Editor(text, header_prev);
    }

    public void setHeading(String heading) {
        String text_prev = ContentStateMemento.getContent().text;
        new Editor(text_prev, heading);
    }

    public String getText() {
        return this.text;
    }

    public String getHeading() {
        return this.heading;
    }

    @Override
    public String toString() {
        return "Editor{" +
                "text='" + text + '\'' +
                ", heading='" + heading + '\'' +
                '}';
    }
}
