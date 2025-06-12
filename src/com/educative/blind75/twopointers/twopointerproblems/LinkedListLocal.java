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
        }
        return !builder.isEmpty() ? builder.substring(0, builder.length() - 1) : "";
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
