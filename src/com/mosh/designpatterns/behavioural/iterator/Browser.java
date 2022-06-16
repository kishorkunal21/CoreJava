package com.mosh.designpatterns.behavioural.iterator;

public class Browser {
    String url;
    public String back() {
        return "back : "+BrowserHistoryNA.pop();
    }

    public void browse(String url) {
        this.url = url;
        BrowserHistoryNA.push(url);
        System.out.println("Browsing "+url);
    }

    void getHistory(){
        System.out.println("History------------------");
        for(String urls:BrowserHistoryNA.getHistory()){
            System.out.println(urls);
        }
        System.out.println("-------------------------");
    }


}
