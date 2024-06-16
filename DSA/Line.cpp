#include<bits/stdc++.h>
// #include<conio.h>
using namespace std;

int main(){
    cout<<"Enter Length : ";
    int n;
    cin>>n;
    string arr[n];
    cout<<"Enter String : ";
    string str;
    cin>>str;
    cout<<"Enter Speed : ";
    int speed;
    cin>>speed;
    for(int i=0;i<n;i++){
        arr[i] = " . ";
    }
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