package Random_Revision;

import java.util.HashMap;
import java.util.Scanner;

class Node {
    int key, val;
    Node prev, next;
    Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

public class LRUCache {
    static HashMap<Integer, Node> cache;
    static int capacity;
    static Node head, tail;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        cache = new HashMap<>();
        System.out.print("Enter Size of Cache: ");
        capacity = in.nextInt();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;

        while (true) {
            System.out.println("1. Put\n2. Get\n3. Exit");
            int ch = in.nextInt();
            if (ch == 1) {
                System.out.print("Enter Key: ");
                int key = in.nextInt();
                System.out.print("Enter Value: ");
                int val = in.nextInt();
                put(key, val);
            } else if (ch == 2) {
                System.out.print("Enter Key: ");
                int key = in.nextInt();
                int result = get(key);
                if (result == -1) {
                    System.out.println("Key not found");
                } else {
                    System.out.println("Value for Key " + key + " is " + result);
                }
            } else {
                break;
            }
        }
    }

    private static void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private static void insertToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private static int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        remove(node);
        insertToFront(node);
        return node.val;
    }

    private static void put(int key, int val) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = val;
            remove(node);
            insertToFront(node);
        } else {
            if (cache.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                cache.remove(lru.key);
            }
            Node newNode = new Node(key, val);
            insertToFront(newNode);
            cache.put(key, newNode);
        }
    }
}
