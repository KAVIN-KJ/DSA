#include<stdio.h>

int q[100],top=0,tail=-1;

void push (int n){
    q[++tail] = n;
}

int pop(){
    if(top>tail) return -1;
    return q[top++];
}

int peek(){
    return q[top];
}

int main(){
    while(1){
        
    }   
}