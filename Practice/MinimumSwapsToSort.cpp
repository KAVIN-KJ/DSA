            #include<bits/stdc++.h>
            using namespace std;

            int main(){
                vector<pair<int,int>> list;
                int n;
                cin>>n;
                int i=0;
                while(i<n){
                    int num;
                    cin>>num;
                    list.push_back({num, i});
                    i++;
                }
                sort(list.begin(),list.end());
                int swaps = 0;
                for(int i=0;i<n;i++){
                    pair<int,int> tempair = list[i];
                    if(i!=tempair.second){
                        swaps++;
                        swap(list[i],list[tempair.second]);
                        i--;
                    }
                }

                cout<<"Minimum Swaps : "<<swaps;

                return 0;
            }               