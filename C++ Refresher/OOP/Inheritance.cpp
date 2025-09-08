#include<iostream>
using namespace std;

class Person{
private: // protected is still like private but visible to derived classes
    string name,company;
    public:
    int age;
    Person(){

    }
    Person(string n,string c,int nu){
        this->name = n;
        this->company = c;
        this->age = nu;
    }
    virtual void printName(){
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
    string getName() {
        return this->name;
    }
    string getCompany(){
        return this->company;
    }
    int getAge(){
        return this->age;
    }
};

class Employee : public Person{ // EMPLOYEE INHERITS PROPERTIES FROM
    //                      A PERSON
    private:
        string role;
        int age = 999;
    public:
        Employee(string name,string company,string dept,int age) : 
        Person(name,company,age){
            this->role = dept;
        }
        string getRole(){
            return this->role;
        }
        void setRole(string s){
            this->role = s;
        }
        void printName() override{
           cout<<getName()<<" from "<<getCompany()<<" is "<<Person::age<<" Years old and he's a "<<role<<"\n";
        }
};

int main(){
    // TRY ACCESSING PERSON FROM EMPLOYEE CLASS
    Person* e = new Employee("KJKR","QWERTY.INC","Developer",22);
    e->printName();
    Person* p = new Person("DON","Movie",22);
    p->printName();
    // cout<<e.getRole()<<"\n";
    // e.setRole("CEO");
    // cout<<e.getRole()<<"\n"; 

     

}