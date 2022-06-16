package com.codewithmosh.designpatterns.behavioural.iterator;

import java.util.List;

public class ListIterator implements Iterator{

    private List<String> list;
    private int index=0;

    public ListIterator(List<String> list){
        this.list= list;
        this.index = list.size()-1;
    }

    @Override
    public boolean hasNext() {
        return index>=0;
    }

    @Override
    public void next() {
        index = index-1;
    }

    @Override
    public String current() {
        return list.get(index);
    }
}
