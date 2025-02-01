package Linked_Lists;


class Node {
    int data;
    Node next;

    Node(int n, Node nd) {
        this.data = n;
        this.next = nd;
    }
}

// REVERSING A LINKED LIST

public class LinkedList {
    public static Node reverseList(Node head) {
        Node prev = null;
        Node temp = head;
        while(temp!=null){
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
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }






}
