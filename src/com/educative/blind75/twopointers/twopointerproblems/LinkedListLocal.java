package com.educative.blind75.twopointers.twopointerproblems;

public class LinkedListLocal {

    Node head;

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
    }

    public void print(){
        if(head!=null){
            Node current = head;
            while(current.next!=null){
                System.out.print(current.value+" ");
                current=current.next;
            }
        }
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
