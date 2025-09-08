#include<iostream>
using namespace std;

class A{
    public:
        void print(){
            cout<<"Class A\n";
        }
};
class B : virtual public A{
    // public:
    //     void print(){
    //         cout<<"Class B\n";
    //     }
};
class C : virtual public A{
    // public:
    //     void print(){
    //         cout<<"Class c\n";
    //     }
};

class D : virtual public B, virtual public C{
    
};

int main(){
    D d;
    d.print();
}