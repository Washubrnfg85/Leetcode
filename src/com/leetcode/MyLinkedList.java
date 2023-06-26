package com.leetcode;

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

public class MyLinkedList {
    private Node root;

    public class Node {
        private int value;
        private Node prev;
        private Node next;

        public Node (int val) {
            this.value = val;
        }
    }

    public MyLinkedList() {
        this.root = null;
    }

    public int get(int index) {
        if (root == null) {
            return -1;
        } else {
            if (index == 0) {
                return root.value;
            } else if (index > getSize() - 1) {
                return -1;
            }
            int count = 0;
            Node current = root;
            while (count < index) {
                if (current.next == null) return -1;
                current = current.next;
                if (current == null) return -1;
                count++;
            }
            return current.value;
        }
    }

    public void addAtHead(int val) {
        Node first = new Node(val);
        if (root == null) {
            root = first;
            return;
        } else {
            Node second = root;
            root = first;
            second.prev = first;
            first.next = second;
        }
    }

    public void addAtTail(int val) {
        Node last = new Node(val);
        if (root == null) {
            root = last;
            return;
        } else {
            Node current = root;
            while (current.next != null) {
                current = current.next;
            }
            current.next = last;
            last.prev = current;
        }
    }

    public void addAtIndex(int index, int val) {
        Node node = new Node(val);
        if (root == null) {
            if (index == 0) {
                root = node;
                return;
            }
            return;
        } else {
            if (index == 0) {
                addAtHead(val);
            } else if (index > getSize()) {
                return;
            } else if (index == getSize()) {
                addAtTail(val);
            } else {
                int count = 1;
                Node current = root;
                while (count < index) {
                    count++;
                    current = current.next;
                }
                Node next = current.next;
                current.next = node;
                node.prev = current;
                node.next = next;
                next.prev = node;
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (root == null) {
            return;
        } else {
            if (index == 0) {
                root = root.next;
                root.prev = null;
            } else if (index > getSize() - 1) {
                return;
            } else {
                int count = 0;
                Node current = root;
                while (count != index) {
                    count++;
                    current = current.next;
                }
                Node previous = current.prev;
                Node next = current.next;
                previous.next = next;
                next.prev = previous;

            }
        }
    }

    public int getSize() {
        if (root == null) return 0;
        int count = 1;
        Node current = root;
        while (current.next != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public String toString() {
        if (root != null && root.next == null) return "" + root.value;
        StringBuilder sb = new StringBuilder();
        Node current = root;
        while (current != null) {
            sb.append(current.value);
            current = current.next;
        }
        return sb.toString();
    }
}
