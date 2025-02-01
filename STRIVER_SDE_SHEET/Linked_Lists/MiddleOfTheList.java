package Linked_Lists;

import Linked_Lists.*;
import java.util.*;
public class MiddleOfTheList {
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
        Node ans = LinkedList.middleOfTheList(head);
        Node temp = LinkedList.reverseList(head);
        System.out.println("Middle of the list :  "+ ans.data);
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

}
