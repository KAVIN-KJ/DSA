#include<iostream>
using namespace std;

class Employee{
    
    private:
    string name,company;
    int age;
    public:
    void printName(){
        cout<<name<<" from "<<company<<" is "<<age<<" Years old";
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
}