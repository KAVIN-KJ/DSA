#include<bits/stdc++.h>
#include<string>
using namespace std;

int main(){
    // String is a class
    string name = "Kavin";
    cout<<name[0]<<"\n";
    // default uninitialized behaviour
    string defau;
    cout<<defau<<"<- Empty String\n";
    // concatenation
    cout<<name+" "+"Raja\n";
    // appending
    name+=" Raja KJ";
    cout<<name<<"\n";
    // string methods : 
    cout<<name.length()<<"\n";
    // reversing
    reverse(name.begin(),name.end());
    cout<<name<<"\n";
    // getting inputs : 
    /*
    
        cout<<"Enter Name : ";
        cin>>name;  // breaks strings on space (kavin raja will be input as kavin)
        cout<<name+"\n";
    // getline
    */
    cout<<"Using getline now input name : ";
    getline(cin,name); 
    cout<<name;
}