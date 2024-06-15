#include<bits/stdc++.h>
// #include<conio.h>
using namespace std;

int main(){
    int n=20;
    string arr[n];
    string str = "KAVIN RAJA";
    for(int i=0;i<n;i++){
        arr[i] = " . ";
    }
    int speed = 100;
    for(int j=0;j<n;j++){
                cout<<arr[j];
    }
    while(true){
        arr[0] = str;
        for(int i=1;i<n;i++){
            arr[i-1] = " . ";
            arr[i] = str;
            for(int j=0;j<n;j++){
                cout<<arr[j];
            }
            this_thread::sleep_for(chrono::milliseconds(speed));
            system("clear");
            cout<<"\n";
        }
        arr[n-1] = str;
        for(int i=n-2;i>=0;i--){
            arr[i+1] = " . ";
            arr[i] = str;
            for(int j=0;j<n;j++){
                cout<<arr[j];
            }
            this_thread::sleep_for(chrono::milliseconds(speed));
            system("clear");
            cout<<"\n";
        }

    }
    return 0;
}