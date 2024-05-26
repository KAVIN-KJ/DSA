#include<bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cout<<"Enter number of Elements : ";
    cin>>n;
    cout<<"Enter array elements separated with a space : ";
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<n-i-1;j++){
            if(arr[j]>arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
    for(int i : arr){
        cout<<i<<"  ";
    }
    return 0;
}