#include<iostream>
using namespace std;

class Employee{
    public:
    string name,company;
    int age;
    void printName(){
        cout<<name<<" from "<<company<<" is "<<age<<" Years old";
    }
};

int main(){
    Employee e;
    e.name = "Kavin Raja K J";
    e.company = "XYZ";
    e.age = 21;
    e.printName();
}