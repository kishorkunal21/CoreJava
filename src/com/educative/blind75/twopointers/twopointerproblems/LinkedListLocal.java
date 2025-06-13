package com.educative.blind75.twopointers.twopointerproblems;

public class LinkedListLocal {

    Node head;
    private static int SIZE = 0;
    private static int LAST = 0;

    //inserting at the end
    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        LAST = current.value;
        SIZE++;
    }

    public int insertAtLast(int value) {
        Node newNode = new Node(value);
        if (head != null) {
            Node current = head;
            while (current.next!=null){
                current = current.next;
            }
            current.next=newNode;
            System.out.println("Insert at last : "+print());
            SIZE++;
            return current.next.value;
        }
        return -1;
    }


    public int remove() {
        //first in first out
        if (head != null) {
            head = head.next;
            SIZE--;
            System.out.println("Removed : " + print());
            return head.value;
        }
        return -1;
    }

    public int removeFromLast() {
        if (head != null) {
            Node current = head;
            for (int i = 0; i < SIZE - 1; i++) {
                current = current.next;
            }
            current.next=null;
            System.out.println("Removed from last : "+print());
            SIZE--;
            return current.value;
        }
        return -1;
    }

    public int peek() {
        return head.value;
    }

    public int size() {
        return SIZE;
    }

    public int tail() {
        return LAST;
    }

    public String print() {
        StringBuilder builder = new StringBuilder();
        if (head != null) {
            Node current = head;
            while (current.next != null) {
                builder.append(current.value).append(",");
                current = current.next;
            }
            builder.append(current.value);
        }
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
