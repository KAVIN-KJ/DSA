#include<stdio.h>


void sort(int arr[],int n){
    for(int i=0;i<n-1;i++){
        for(int j=0;j<n-1;j++){
            if(arr[j] > arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}



int main(){
    // char car[][20] = {"Mustang","Corvette","Bugatti","Ferrari","Tesla","AlfaRomeo","Lamborghini"};
    // for(int i=0;i<sizeof(car)/sizeof(car[0]);i++){
    //     printf("%s\n",car[i]);
    // }
    
    int arr[] = {5,6,8,9,7,2,1,3,4,5,6};
    int n = sizeof(arr)/sizeof(arr[0]);
    for(int i=0;i<n;i++){
        printf("%d ",arr[i]);
    }       

    sort(arr,n);
    printf("\n");
    for(int i=0;i<n;i++){
        printf("%d ",arr[i]);
    }       

    return 0;
}