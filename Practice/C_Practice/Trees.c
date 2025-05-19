#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>


typedef struct Node{
    int data;
    Node* left;
    Node* right;
} Node;


Node* q[100];
int top=0,tail=-1;

void push(Node* n){
    q[++tail] = n;
}

int empty(){
    return (top>tail);
}

Node* pop(){
    if(top>tail){
        return  NULL;
    }
    return q[top++];
}

Node* peek(){
    return q[top];
}

Node* insert(Node* root,int val){
    if(root==NULL){
        Node* newnode = (Node*)malloc(sizeof(Node));
        newnode->data = val;
        return newnode;
    }
    if(val<root->data){
        root->left = insert(root->left,val);
    }
    else{
        root->right = insert(root->right,val);
    }
    return root;
}

void display(Node* root){
    if(root==NULL) return;
    display(root->left);
    printf("%d ",root->data);
    display(root->right);
}

Node* smallest(Node* root){
    if(root==NULL) return root;
    return(root->left);
}

void lv_order(Node* root){
    if(root==NULL) return;
    push(root);
    while(!empty()){
        int lvl = tail-top +1;
        for(int i=0;i<lvl;i++){
            Node* curr = pop();
            if(curr!=NULL){
                printf("%d ",curr->data);
                if(curr->left != NULL) push(curr->left);
                if(curr->right != NULL) push(curr->right);
            }
        }
        printf("\n");
    }
}


int main(){
    Node* root = NULL;
    int x = 0;
    while(empty()){
        scanf("%d",&x);
        if(x==-1) break;
        root = insert(root,x);
    }
    // display(root);
    printf("Level order : \n");
    lv_order(root);
    Node* small = smallest(root);
    printf("Smallest Node in the tree is : %d located at %a",small->data,small);
    return 0;
}