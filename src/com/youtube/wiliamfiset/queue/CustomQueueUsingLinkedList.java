package com.youtube.wiliamfiset.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;

//https://www.youtube.com/watch?v=EoisnPvUkOA&list=PLDV1Zeh2NRsAWrxWRTHJrsgBrbwqGzt-z&index=1
/*
Notes :
    1. Can be implemented using array/singly linked list or doubly linked list
    2. Used in BFS
*/
public class CustomQueueUsingLinkedList<E> implements Iterable<E> {

    private final LinkedList<E> list = new LinkedList<>();

    public static void main(String[] args) {
        // queue implementation BFS

        CustomQueueUsingLinkedList<Integer> queue = new CustomQueueUsingLinkedList<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println(queue.list);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.isEmpty());

    }

    //when we enqueue - we push the tail pointer forward on every element
    private  void enqueue(E e) {
        list.add(e);
        System.out.println(list);
    }
    //when we dequeue or remove : removes and returns the deleted head element
    // - we push the current head pointer forward and make the last node - that is collected by GC
    private E dequeue() {
        E e =  list.remove();//removes the first element
        System.out.println("removed : "+e+" "+list);
        return e;
    }

    // return item from head
    private  E peek() {
        return list.peek();
    }

    private  boolean isEmpty() {
        return list.isEmpty();
    }


    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return Iterable.super.spliterator();
    }
}
