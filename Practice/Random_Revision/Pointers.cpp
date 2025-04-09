#include <iostream>
using namespace std;

void modifyarray(int *arr, int n)
{

    for (int i = 0; i < n; i++)
    {
        *(arr + i) = *(arr + i) * *(arr + i);
    }
}

// int* danglingptr(){
//     int a = 10;
//     return &a;
// }

int main()
{

    /*

    BASICS

    int a = 10;
    int* p = &a;
    int **pp = &p;
    cout<<*pp<<endl;
    cout<<&a;

    */
    /*

        POINTERS IN ARRAYS

        int arr[] = {10,20,30,40,50};
        int *p = arr;
        int *end = arr+sizeof(arr)/sizeof(arr[0]);
        while(p!=end){
            cout<<*p<<"\n";
            p+=1;
        }

        cout<<"First element "<<arr[0]<<" Using Pointer : "<<*p<<"\n";
        cout<<"Traversal using pointer arithmetic\n";
        for(int i=0;i<sizeof(arr)/sizeof(*p);i++){
            cout<<*(arr+i)<<"\n";
        }


        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int *p = arr;
        cout<<sizeof(p)<<" "<<sizeof(arr)<<"\n";
        for(int i=0;i<10;i++){
            cout<<*(p+i)<<" ";
        }


    */
    /*

            PASS BY REFERENCE

            int arr[] = {1,2,3,4,5,6,7,8,9,10};

            modifyarray(arr,10);

            cout<<"Modified Array : \n";
            for(int i=0;i<10;i++){
                cout<<*(arr+i)<<" ";
            }
            cout<<"\n";

    */

    // cout<<danglingptr(); CAUSES ERROR (ADDRESS OF LOCAL VAR RETURNED)


    int arr[] = {10,20,30,40,50,60,70,80,90,100};
    int* p = arr;
    for(int i=0;i<size(arr);i++){
        cout<<*p++<<" ";
    }
    cout<<"\n";



    return 0;
}