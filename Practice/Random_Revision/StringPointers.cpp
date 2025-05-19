#include <bits/stdc++.h>
#define Print(num) cout<<"The value of " "#num" " is "<<num
using namespace std;


void copyString(char* s,char* c){  

    int n = sizeof(s);
    char* p1 = s;
    char* p2 = c;
    while(*p1!='\0'){
        *p2++ = *p1++;
    }
}


int main(){

    // int n = printf("%d",printf("%d"));
    // cout<<n<<"\n";
    // return 0;
    // short i = 0;
    // while(true){
    //     cout<<i--<<"\n";
    // }
    int n;
    printf("%d",scanf("%d",&n));
}


// int main()
// {

//     //   SUBSTRING FINDER WITHOUT SUBSTR FUNCTION

//         // char str[] = "abcdSUBSTRINGabcd";
//         // char *ptr = str;
//         // ptr += 4;
//         // *(ptr + 9) = '\0';
//         // cout << ptr << "\n";

//         char s[20] = "K_J_KAVIN_RAJA";
//         char c[20];
//         copyString(s,c);
//         cout<<s<<"\n";
//         cout<<c<<" \n";
// }