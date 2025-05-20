package Stacks;

import java.util.*;


class stack{
    Queue<Integer> q;
    stack(){
        q = new LinkedList<>();
    }
    public void push(int val){
        int n = q.size();
        q.add(val);
        for(int i=0;i<n;i++){
            q.add(q.poll());
        }
    }
    public int pop(){
        // int n = q.peek();
        return q.poll();
    }
    public int top(){
        return q.peek();
    }
    public boolean empty(){
        return q.size()==0;
    }
}


public class StackUsingQueue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        stack s = new stack();
        in.close();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);
        s.push(70);
        while(!s.empty()){
            System.out.println(s.pop());
        }
    }
}
