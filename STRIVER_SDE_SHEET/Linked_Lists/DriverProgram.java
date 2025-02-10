package Linked_Lists;

import java.util.Scanner;

public class DriverProgram {
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
        head = LinkedList.reverseList(head);
        in.close();
        head = LinkedList.rotateRight(head,3);
        LinkedList.display(head);
        // System.out.println(LinkedList.isPalindrome(head));
    }
}
