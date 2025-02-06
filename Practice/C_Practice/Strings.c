#include<stdio.h>
#include<string.h>
int main(){

    char s1[] = "Kavin";
    char s2[] = "Kavi";

    // strupr(s1);

    // strncpy(s1,s2,2);
    // strcat(s1," ");
    // strcat(s1,s2);
    int n = strcmp(s1,s2);
    printf("%d\n",n);

    return 0;
}