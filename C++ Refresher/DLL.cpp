#include<iostream>
using namespace std;

class node{
    public:
        int v;
        node* next;
        node* prev;
        node(int v){
            this->v = v;
            next = nullptr;
            prev = nullptr;
        }
};

void insert_front(node *head,int v){
    node* newnode = new node(v);
    newnode->prev = head;
    newnode->next = head->next;
    head->next->prev = newnode;
    head->next = newnode;
}

void insert_last(node* tail,int v){
    node* newnode = new node(v);
    newnode->prev = tail->prev;
    newnode->next = tail;
    tail->prev->next = newnode;
    tail->prev = newnode;
}

void traverse(node* head, node* tail){
    node* temp = head->next;
    while(temp!=tail){
        cout<<temp->v<<"\t";
        temp = temp->next;
    }
}

int main(){
    node* head = new node(-1);
    node* tail = new node(-1);
    head->next = tail;
    tail->prev = head;
    cout<<"Enter Node values : ";
    while(true){
        string s;
        cin>>s;
        if(s=="stop") break;
        int n = stoi(s);
        insert_last(tail,n);
    }
    traverse(head,tail);
}