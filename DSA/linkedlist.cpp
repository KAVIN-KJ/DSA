#include<bits/stdc++.h>
using namespace std;

struct node{
    int data;
    node* next=nullptr;
};

void addnode(int data,node* &head){
        node* newnode = new node();
        newnode->data = data;
        newnode->next = head;
        head = newnode;
}

void display(node* &temp){
    while(temp!=NULL){
        cout<<temp->data<<" ";
        temp = temp->next;
    }
    cout<<"\n";
    return;
}


int main(){
    node *head=nullptr;
    int n;
    cout<<"No of elements : ";
    cin>>n;
    for(int i=0;i<n;i++){
        int a;
        cin>>a;
        addnode(a,head);
    }
    try{
        display(head);
    }
    catch(string e){
        cout<<e;
    }
    return 0;
}