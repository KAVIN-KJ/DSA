#include<bits/stdc++.h>
using namespace std;

struct node
{
    int data;
    node* next=NULL;
};


void addnode(int a,node* &head){
    node* newnode = new node();
    newnode->data = a;
    newnode->next = head;
    head = newnode;
}

void display(node* &head){
    node* temp = head;
    while(temp!=NULL){
        cout<<temp->data<<" ";
        temp = temp->next;
    }
    cout<<"\n";

}

int main(){
    node* head=NULL;
    int n;
    cin>>n;
    int a;
    for(int i=0;i<n;i++){
        cin>>a;
        addnode(a,head);
    }
    display(head);
}




