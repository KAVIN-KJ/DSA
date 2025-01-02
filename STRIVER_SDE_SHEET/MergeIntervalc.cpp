#include<bits/stdc++.h>
using namespace std;
vector<vector<int>> merge(vector<vector<int>>& arr) {
        vector<vector<int>> ans;
        int n = arr.size();
        sort(arr.begin(),arr.end());
        for(int i=0;i<n;i++){
            int st = arr[i][0];
            int nd = arr[i][1];
            if(ans.empty() || st > ans.back()[1]){
                ans.push_back({st,nd});
            }
            else{
                ans.back()[1] = max(ans.back()[1],nd);
            }
        }
        return ans;
}
int main(){
    vector<vector<int>> arr;
    int n;
    cin>>n;
    for(int i=0;i<n;i++){
        int a;
        int b;
        cin>>a>>b;
        arr.push_back({a,b});
    }

    arr = merge(arr);
    for(int i=0;i<arr.size();i++){
        cout<<arr[i][0]<<" "<<arr[i][1]<<"\n";
    }
    return 0;
}