#include<bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin>>n;
    vector<int> arr(n);
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int mini = INT_MAX;
    int maxprofit = arr[0];
    for(int i : arr){
        mini = min(mini,i);
        maxprofit = max(maxprofit,i-mini);
    }
    cout<<maxprofit<<" is the maximum possible profit";
}