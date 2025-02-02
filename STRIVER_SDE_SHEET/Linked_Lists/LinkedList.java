package Linked_Lists;

class Node {
    int data;
    Node next;

    Node(int n, Node nx) {
        this.data = n;
        this.next = nx;
    }
}

// REVERSING A LINKED LIST

public class LinkedList {
    public static Node reverseList(Node head) {
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    // MIDDLE ELEMENT OF A LIST

    public static Node middleOfTheList(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // MERGE TWO SORTED LISTS

    public static Node mergeSortedLists(Node l1, Node l2) {
        Node res = null;
        Node restail = null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        Node ptr1 = l1;
        Node ptr2 = l2;
        while (ptr1 != null && ptr2 != null) {
            int data = 0;
            if (ptr1.data >= ptr2.data) {
                data = ptr2.data;
                ptr2 = ptr2.next;
            } else {
                data = ptr1.data;
                ptr1 = ptr1.next;
            }
            Node newnode = new Node(data, null);
            if (res == null) {
                res = newnode;
                restail = newnode;
            } else {
                restail.next = newnode;
                restail = newnode;
            }
        }
        while (ptr1 != null) {
            Node newnode = new Node(ptr1.data, null);
            if (restail != null)
                restail.next = newnode;
            restail = newnode;
            ptr1 = ptr1.next;
        }
        while (ptr2 != null) {
            Node newnode = new Node(ptr2.data, null);
            if (restail != null)
                restail.next = newnode;
            restail = newnode;
            ptr2 = ptr2.next;
        }
        System.gc();
        return res;
    }
}
