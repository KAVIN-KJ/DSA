#include<bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin>>n;
    string arr[n];
    for(int i=0;i<n;i++) cin>>arr[i];

    for(int i=0;i<arr[0].size();i++){
        char c = arr[0][i];
        for(int j=1;j<n;j++){
            if(arr[j][i]!=c||i>=arr[j].size()){
                cout<<arr[0].substr(0,i)<<" Is the Longest common Prefix";
                return 0;
            }
        }
    }
    cout<<arr[0]<<" Is the Longest common Prefix";

}