import java.util.*;

class node {
    node prev, next;
    int key;
    int val;

    node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

public class LRUCache {
    static node head = null;
    static node tail = null;
    static int size = 0;
    static int n = 0;
    static HashMap<Integer, node> map = new HashMap<>();

    static void put(int key, int val) {
        if (map.containsKey(key)) {
            node temp = map.get(key);
            temp.val = val;
            if (temp != head) {
                if (temp.prev != null)
                    temp.prev.next = temp.next;
                if (temp.next != null)
                    temp.next.prev = temp.prev;
                if (temp == tail)
                    tail = temp.prev;
                temp.prev = null;
                temp.next = head;
                head.prev = temp;
                head = temp;
            }
        }
        else{
            node newnode = new node(key, val);
            if (head == null) {
                head = newnode;
                tail = newnode;
                size++;
                return;
            }
        }
    }

    static int get(int key) {
        node temp = head;
        while (temp != null) {
            if (temp.key == key) {
                if (temp != head) {
                    if (temp.prev != null)
                        temp.prev.next = temp.next;
                    if (temp.next != null)
                        temp.next.prev = temp.prev;
                    if (temp == tail)
                        tail = temp.prev;
                    temp.prev = null;
                    temp.next = head;
                    head.prev = temp;
                    head = temp;
                }
                return temp.val;
            }
            temp = temp.next;
        }
        return -1;
    }

    static void display() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.key + " " + temp.val + " | ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        put(1, 1);
        display();
        put(2, 2);
        display();
        System.out.println(get(1));
        display();
        put(3, 3);
        display();
        System.out.println(get(2));
        display();
        put(4, 4);
        System.out.println(get(1));
        display();
        System.out.println(get(3));
        display();
        System.out.println(get(4));
        display();
    }
}

/*
 * 
 * import java.util.Scanner;
 * import java.util.HashMap;
 * 
 * class node {
 * node prev, next;
 * int key;
 * int val;
 * 
 * node(int key, int val) {
 * this.key = key;
 * this.val = val;
 * this.next = null;
 * this.prev = null;
 * }
 * }
 * 
 * public class LRUCache {
 * static node head = null;
 * static node tail = null;
 * static int size = 0;
 * static int n = 0;
 * static HashMap<Integer, node> map = new HashMap<>();
 * 
 * static void put(int key, int val) {
 * if (map.containsKey(key)) {
 * node temp = map.get(key);
 * temp.val = val;
 * if (temp != head) {
 * if (temp.prev != null)
 * temp.prev.next = temp.next;
 * if (temp.next != null)
 * temp.next.prev = temp.prev;
 * if (temp == tail)
 * tail = temp.prev;
 * temp.prev = null;
 * temp.next = head;
 * head.prev = temp;
 * head = temp;
 * }
 * return;
 * }
 * 
 * node newnode = new node(key, val);
 * map.put(key, newnode);
 * if (head == null) {
 * head = newnode;
 * tail = newnode;
 * size++;
 * return;
 * }
 * if (size >= n) {
 * if (tail != null) {
 * map.remove(tail.key);
 * if (tail.prev != null) {
 * tail = tail.prev;
 * tail.next = null;
 * } else {
 * head = null;
 * tail = null;
 * }
 * size--;
 * }
 * }
 * newnode.next = head;
 * head.prev = newnode;
 * head = newnode;
 * size++;
 * }
 * 
 * static int get(int key) {
 * if (!map.containsKey(key))
 * return -1;
 * node temp = map.get(key);
 * if (temp != head) {
 * if (temp.prev != null)
 * temp.prev.next = temp.next;
 * if (temp.next != null)
 * temp.next.prev = temp.prev;
 * if (temp == tail)
 * tail = temp.prev;
 * temp.prev = null;
 * temp.next = head;
 * head.prev = temp;
 * head = temp;
 * }
 * return temp.val;
 * }
 * 
 * static void display() {
 * node temp = head;
 * while (temp != null) {
 * System.out.println(temp.key + " " + temp.val);
 * temp = temp.next;
 * }
 * }
 * 
 * public static void main(String[] args) {
 * Scanner in = new Scanner(System.in);
 * n = in.nextInt();
 * put(1, 1);
 * display();
 * put(2, 2);
 * display();
 * System.out.println(get(1));
 * display();
 * put(3, 3);
 * display();
 * System.out.println(get(2));
 * display();
 * put(4, 4);
 * System.out.println(get(1));
 * display();
 * System.out.println(get(3));
 * display();
 * System.out.println(get(4));
 * display();
 * }
 * }
 * 
 */