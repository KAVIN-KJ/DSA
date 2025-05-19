#include<iostream>
using namespace std;

struct node{
    int data;
    node* left;
    node* right;
};

node *insert(node* &root,int value){
    node* newnode = new node();
    if(root==nullptr){
        newnode->data = value;
        newnode->left = nullptr;
        newnode->right = nullptr;
        root = newnode;
        return root;
    }
    else if(root->data > value){
       root->right = insert(root->right,value);

    }
    else{
       root->left =  insert(root->left,value);
    }
    return root;
}
void display(node* &root){
    if(root==nullptr){
        return;
    }
    display(root->right);
    cout<<root->data<<" ";
    display(root->left);
}

int main(){
    node* root=nullptr;
    int data;
    while(true){
        cin>>data;
        if(data<0){
            break;
        }
        root = insert(root,data);
    }
    display(root);

    return 0;
}