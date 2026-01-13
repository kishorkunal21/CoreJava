package com.educative.blind75.twopointers.twopointerproblems;

public class LinkedListLocalRemoveNthNodeFromEnd {
    public static void main(String[] args) {

    }
//todo implement
    Node getHead() {
        return head;
    }

    Node head;
    private int size = 0;
    private int last = 0;

    //inserting at the end
    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        last = current.next.value;
        size++;
    }

    public int insertAtLast(int value) {
        Node newNode = new Node(value);
        if (head != null) {
            Node current = head;
            while (current.next!=null){
                current = current.next;
            }
            current.next=newNode;
            size++;
            return current.next.value;
        }
        return -1;
    }


    public int remove() {
        //first in first out
        if (head != null) {
            head = head.next;
            size--;
            return head!=null? head.value : -1;
        }
        return -1;
    }

    public int removeFromLast() {
        if (head != null) {
            Node current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            current.next=null;
            size--;
            return current.value;
        }
        return -1;
    }

    public int peek() {
        return head.value;
    }

    public int size() {
        return size;
    }

    public int tail() {
        return last;
    }

    public String print() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        if (head != null) {
            Node current = head;
            while (current.next != null) {
                builder.append(current.value).append(",");
                current = current.next;
            }
            builder.append(current.value);
        }
        builder.append("]");
        return builder.toString();
    }


    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

}
