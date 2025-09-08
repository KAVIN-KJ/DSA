#include <bits/stdc++.h>
using namespace std;
int main()
{
    int *arr = NULL;
    arr = new int[10]();
    int a[10];
    for (int i = 0; i < 10; i++)
        cout << *(arr + i) << "\n";
    cout << arr << " " << *arr << " " << &arr;
    vector<int> v(20, 0);
    cout << "\n";
    for (int i : v)
        cout << i << " ";
}
