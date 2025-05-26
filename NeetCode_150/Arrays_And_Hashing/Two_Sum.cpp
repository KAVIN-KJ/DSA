#include<bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cout<<"Enter NUmber of elements : ";
    cin>>n;
    int arr[n];
    cout<<"Enter array elements : ";
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    cout<<"Enter target : ";
    int trgt;
    cin>>trgt;
    int ans[2];
    unordered_map<int,int> mpp;
    for(int i=0;i<n;i++){
        int req = trgt-arr[i];
        if(mpp.find(req)!=mpp.end()){
            ans[0] = mpp[req];
            ans[1] = i;
        }
        mpp[arr[i]] = i;
    }
    cout<<"The indices are : "<<ans[0]<<" "<<ans[1]<<"\n";
} 