#include<iostream>
using namespace std;

class Employee{
    
    private:
    string name,company;
    int age;
    public:
    Employee(){

    }
    Employee(string n,string c,int nu){
        this->name = n;
        this->company = c;
        this->age = nu;
    }
    void printName(){
        cout<<name<<" from "<<company<<" is "<<age<<" Years old\n";
    }
    void setName(string name){
        this->name = name;
    }
    void setCompany(string company){
        this->company = company;
    }
    void setAge(int n){
        this->age = n;
    }
};

int main(){
    Employee e;
    e.setName("Kavin Raja K J");
    e.setCompany("XYZ");
    e.setAge(21);
    e.printName();
    Employee e2("KJKR","ABC",21);
    e2.printName();
}