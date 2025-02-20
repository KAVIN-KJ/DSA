package Stacks;

import java.util.*;

class queue{
    Stack<Integer> ip,op;
    queue(){
        ip = new Stack<>();
        op = new Stack<>();
    }
    public void push(int val){
        while(!ip.empty()){
            op.push(ip.pop());
        }
        ip.push(val);
        while(!op.empty()){
            ip.push(op.pop());
        }
    }
    public int pop(){
        if(ip.empty()) return -1;
        return ip.pop();
    }
    public int peek(){
        if(ip.empty()) return -1;
        return ip.peek();
    }
    public int size(){
        return ip.size();
    }
}

public class QueueUsingStack {
    public static void main(String[] args) {
        
    }
}
