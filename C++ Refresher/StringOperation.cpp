#include<bits/stdc++.h>
using namespace std;

int main(){
    // String replacing
    string s = "What the Fuck !\n";
    int i = s.find("Fuck");
    s.replace(i,4,"****");
    cout<<s;
    // substring
    cout<<s.substr(0,4)<<"\n";
}