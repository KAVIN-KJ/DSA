package Linked_Lists;

import java.util.*;

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
        head = LinkedList.reverseList(head);
        temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


}