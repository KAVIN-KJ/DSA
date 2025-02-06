#include<stdio.h>
#include<stdlib.h>
// typedef is used ot create a nickname of a variable
// for example instead of using char[25] we can create 
// a typedef called string like so :
// syntax : " typedef datatype nickname "
typedef char string[50]; 


typedef struct student{
    string name;
    int age;
} student;


typedef struct Node
{
    int data;
    Node* next;
} Node;


Node* insert(Node* head,int val){
    Node* newnode =(Node*)malloc(sizeof(Node));
    newnode->next = head;
    newnode->data = val;
    head = newnode;
    return head;
}

void display(Node* head){
    Node* temp = head;
    while(temp!=NULL){
        printf("%d ",temp->data);
        temp = temp->next;
    }
}
 
int main(){
    // string name = "Kavin Raja K J is Always Goated !! 🐐🐐🐐\n";
    
    // string arr[] = {"KJKR","Jayabharathi","NSK",};
    // for(int i=0;i<sizeof(arr)/sizeof(arr[0]);i++){
    //     printf("%s\n",arr[i]);
    // }
    // Node* head = NULL;
    // head = insert(head,1);
    // head = insert(head,2);
    // head = insert(head,3);
    // head = insert(head,4);
    // head = insert(head,5);
    // head = insert(head,6);
    // head = insert(head,7);
    
    // display(head);

    student students[] = {{"Kavin",20},{"Jayabharathi",45},{"Karuppusamy",52}};
    for(int i=0;i<sizeof(students)/sizeof(students[0]);i++){
        printf("Name : %s\nAge : %d\n",students[i].name,students[i].age);
    }

    return 0;
}