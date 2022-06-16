package com.codewithmosh.designpatterns.behavioural.iterator;

import java.util.Stack;

public class BrowserHistory {

    private static Stack<String> urlsHistory = new Stack<>();

    static void push(String url){
        urlsHistory.push(url);
    }

    static String pop(){
        return urlsHistory.pop();
    }

    static void getHistory(){
        Iterator iterator =new ListIterator(urlsHistory);
        while (iterator.hasNext()){
            System.out.println(iterator.current());
            iterator.next();
        }
    }

}
