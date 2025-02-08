package Linked_Lists;

class Node {
    int data;
    Node next;

    Node(int n, Node nx) {
        this.data = n;
        this.next = nx;
    }

    public Node(int i) {
        this.data = i;
    }
}

class Node2{
    int data;
    Node next;
    Node bottom;
    Node2(int n,Node nex,Node bot){
        this.data = n;
        this.next = nex; 
        this.bottom = bot;
    }
}


// LINKED LIST CLASS

public class LinkedList {

    // DISPLAYING THE LIST

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    // REVERSING A LINKED LIST

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

    // REMOVE Nth NODE FROM LIST

    public static Node removeFromLast(Node head, int n) {
        if (head.next == null)
            return null;
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null)
            return head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        if (slow.next != null)
            slow.next = slow.next.next;
        return head;
    }

    // ADD TWO NUMBERS AS LIST

    public static Node addTwoNumbers(Node l1, Node l2) {
        int carry = 0;
        Node ans = new Node(0);
        Node temp = ans;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
        }
        return ans.next;
    }

    // INTERSECTION OF TWO LISTS

    public static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null)
            return null;
        Node l1 = headA;
        Node l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }

    // HAS CYCLE ?
    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null)
            return false;
        Node sl = head;
        Node fs = head;
        while (fs != null && fs.next != null) {
            fs = fs.next.next;
            sl = sl.next;
            if (sl == fs)
                return true;    
        }
        return false;
    }

    // FIND KTH ELEMENT FROM GIVEN HEAD

    static Node kth_element(Node head, int k) {
        Node temp = head;
        int i = 0;
        while (i < k - 1 && temp != null) {
            temp = temp.next;
            i++;
        }
        return temp;
    }

    // REVERSE LIST BY K GROUP SIZE

    static Node reverseByK(Node head, int k) {
        Node temp = head;
        
        Node prevNode = null;
        while (temp != null) {
            Node kthNode = kth_element(temp, k);
            if (kthNode == null) {
                if(prevNode!=null)
                    prevNode.next = temp;
                break;
            }
            Node nextNode = kthNode.next;
            kthNode.next = null;
            reverseList(temp);
            if (temp == head) {
                head = kthNode;
            } else {
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }

    // PALINDROMIC LIST OR NOT ?

    public static boolean isPalindrome(Node head) {
        if(head==null || head.next==null) return true;
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newhead = reverseList(slow.next);
        Node l1 = head;
        Node l2 = newhead;
        while(l2!=null){
            if(l1.data!=l2.data){
                reverseList(newhead);
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        reverseList(newhead);
        return true;
    }

    // DETECT CYCLE IN A LIST

    static Node detectCycle(Node head){
        if(head==null) return null;
        Node sl = head;
        Node fs = head;
        while(sl!=null && fs!=null && fs.next!=null){
            sl = sl.next;
            fs = fs.next.next;
            if(sl==fs){
                fs = head;
                while(sl!=fs){
                    sl = sl.next;
                    fs = fs.next;
                }
                return fs;
            }
        }
        return null;
    }

    // FLATTEN A LINKED LIST

    static Node flattenList(Node2 head){
        return null;
    }

}

