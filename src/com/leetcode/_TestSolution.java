package com.leetcode;

public class _TestSolution {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3, 0);
        System.out.println(list);

        list.deleteAtIndex(2);
        System.out.println(list);

        list.addAtHead(6);
        list.addAtTail(4);
        System.out.println(list);
        System.out.println(list.get(4));

        list.addAtHead(4);
        list.addAtIndex(5, 0);
        list.addAtHead(6);
        System.out.println(list);

    }
}
