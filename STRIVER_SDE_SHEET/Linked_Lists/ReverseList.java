package Linked_Lists;

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int n, Node nd) {
        this.data = n;
        this.next = nd;
    }
}

public class ReverseList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Node head = null;
        while (true) {
            int x = in.nextInt();
            if (x == -1)
                break;
            Node newnode = new Node(x, head);
            head = newnode;
        }
        in.close();
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        head = reverseList(head);
        temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private static Node reverseList(Node head) {
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

}