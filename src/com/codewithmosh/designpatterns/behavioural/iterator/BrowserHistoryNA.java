package com.codewithmosh.designpatterns.behavioural.iterator;

import java.util.List;
import java.util.Stack;

public class BrowserHistoryNA {

    private static Stack<String> urlsHistory = new Stack<>();

    static void push(String url){
        urlsHistory.push(url);
    }

    static String pop(){
        return urlsHistory.pop();
    }

    static List<String> getHistory(){
        return urlsHistory;
    }

}
