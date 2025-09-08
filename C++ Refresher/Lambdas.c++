#include<bits/stdc++.h>
using namespace std;
int main(){
    auto inner = [](int x)->double{
        return static_cast<double>(x)/2;
    };
    cout<<inner(19)<<"\n";
}