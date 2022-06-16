package com.mosh.designpatterns.behavioural.iterator;

// Iterator is to separate the Iteration task and keep it common -
// extendable to any kind of collection in future
public class Main {
    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.browse("google.com");
        browser.browse("amazon.com");
        browser.browse("flipkart.com");
        browser.browse("nyka.com");

        browser.getHistory();

        System.out.println(browser.back());
        System.out.println(browser.back());
        System.out.println(browser.back());
        System.out.println(browser.back());



    }
}
