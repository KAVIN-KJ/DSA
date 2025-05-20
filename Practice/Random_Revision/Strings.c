#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(){
    char name[20];
    fgets(name,sizeof(name),stdin);
    // strcat(name,".");
    name[20] = '/n';
    printf("%s",name);
}

