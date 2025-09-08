#include <iostream>
#include <string>
using namespace std;

int main()
{
    string name = "Hello";
    // getline(cin,name);
    cout << name.length() << "\n";
    name.append(" KJ");
    cout << name << "\n";
    name.insert(5, " Kavin");
    cout << name << "\n";
    // (index, size to be removed after index)
    name.erase(5, 6);
    cout << name << "\n";
    // (index,size of string to be replaced with new string)
    name.replace(5, 1, " Raja ");

    cout << name << "\n";
}