package com.educative.blind75.twopointers.twopointerproblems;

import java.util.*;

/*
Given the head of a singly linked list and an integer n,
remove the nth node from the end of the list and return the head of the modified list

 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        /*inputs.put(5,  new LinkedList<>(Arrays.asList(12 , 15 , 13 , 16 , 17 , 14 , null)));
        inputs.put(6,  new LinkedList<>(Arrays.asList(10 , 20 , 30 , 40 , 50 , 60 , null)));
*/
        LinkedListLocal local = new LinkedListLocal();
        local.insert(32);
        local.insert(78);
        local.insert(65);
        local.insert(90);
        local.insert(12);
        local.insert(44);
        System.out.println(local.print() + " " + local.size());

        System.out.println("new head after remove from head: " + local.remove() + " " + local.print() + " " + local.size());
        local.insert(33);
        System.out.println("new insert at tail : " + local.print() + " " + local.size());
        System.out.println("new end after remove from last : " + local.removeFromLast() + " " + local.print() + " " + local.size());

        System.out.println("new insert last : " + local.insertAtLast(111) + " " + local.size());
        remove(local, 3);

    }

    private static int remove(LinkedListLocal local, int index) {

        System.out.println("\nRemoving " + index + " index value from last of " + local.print() + " of size " + local.size());

        int p1 = local.size() - index, p2 = local.size();

        System.out.println(p1 + " " + p2);

        LinkedListLocal.Node current = local.head;

        for (int i = 1; i <= p1; i++) {
            current = current.next;
            System.out.println(current);
        }
        current = current.next;
        System.out.println(current);

        return -1;
    }


}
