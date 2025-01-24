#include<bits/stdc++.h>
using namespace std;

struct node{
    int data;
    node* left;
    node* right;
    node(int x){
        data = x;
        left = right = NULL;
    }
};


node* insert(node* root,int val){
    if(root==NULL){
        return new node(val);
    }
    else if(val<root->data){
        root->left = insert(root->left,val);
    }
    else if(val>root->data) {
        root->right = insert(root->right,val);
    }
    return root;
}

void levelOrderTraversal(node* root){
    queue<node*> q;
    q.push(root);
    while(!q.empty()){
        int qsize = q.size();
        for(int i=0;i<qsize;i++){
            node* curr = q.front();
            q.pop();
            cout<<curr->data<<"\t";
            if(curr->left!=nullptr) q.push(curr->left);
            if(curr->right!=nullptr) q.push(curr->right);
        }
        cout<<"\n";
    }
}

node* minValue(node* root){
    node* curr = root;
    while(curr && curr->left != NULL){
        curr = curr->left;
    }
    return curr;
}


node* deleteNode(node* root,int val){
    if(root==nullptr) return root;

    if(val<root->data){
        root->left = deleteNode(root->left,val);
    }
    else if(val>root->data){
        root->right = deleteNode(root->right,val);
    }
    else{
        if(root->left == nullptr){
            node* temp = root->right;
            delete root;
            return temp;
        }
        if(root->right == nullptr){
            node* temp = root->left;
            delete root;
            return temp;
        }
        node* temp = minValue(root->right);
        root->data = temp->data;
        root = deleteNode(root->right,temp->data);
    }

    return root;

}

void display(node* root){
    if(root==nullptr){
        return;   
    }
    display(root->left);
    cout<<"Node :\t"<<root<<"\t"<<root->data<<endl;
    display(root->right);
}


int main(){
    node* root = NULL;
    while(true){
        int n;
        cin>>n;
        if(n==-1) break;
        root = insert(root,n);
    }
    // display(root);
    cout<<"Minimum value : "<<minValue(root)->data<<endl;
    cout<<"Level order Traversal : \n";
    levelOrderTraversal(root);
    cout<<"Enter value to be Deleted : ";
    int val;
    cin>>val;
    root = deleteNode(root,val);
    levelOrderTraversal(root);
    return 0;
}