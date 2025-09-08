#include<bits/stdc++.h>
using namespace std;

class Point{
    public:
        int x,y;
        string name;
        // Point(int x,int y){
            
        // }
};

int main(){
    vector<Point> pts = {{0,2,"KJKR"},{2,2,"QWERTY"},
                        {4,5,"ABCD"},{6,7,"HEHEHE"},
                        {1,4,"ABABABABA"}};
    for(Point i : pts){
        cout<<i.x<<" "<<i.y<<" "<<i.name<<"\n";
    }
    Point p = {10,20,"New Object !"};
    cout<<p.x<<" "<<p.y<<" "<<p.name; 
}