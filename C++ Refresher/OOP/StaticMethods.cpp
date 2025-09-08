#include<bits/stdc++.h>
using namespace std; 
class Dummy{
    string s;
    public:
    Dummy(string s){
        this->s = s;
    }
    static void printNames(vector<Dummy*> arr){
        for(auto i : arr){
            cout<<i->s<<"\n";
        }
    }
};
int main(){
    vector<Dummy*>arr;
    arr.push_back(new Dummy("KJKR"));
    arr.push_back(new Dummy("kjkr"));
    arr.push_back(new Dummy("KAVIN"));
    arr.push_back(new Dummy("RAJA"));
    arr.push_back(new Dummy("KAVIN RAJA K J"));
    Dummy::printNames(arr);
}