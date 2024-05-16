class Solution {
public:
    int reverse(int x) {
        long limit = pow(2,31);
        if(x>limit || x<-limit){
            return 0;
        }
        long ans=0;
        while(x>0 || x<0){
            ans+=x%10;
            ans*=10;
            x/=10;
        }
        ans=ans/10;
        if(ans>limit||ans<-limit){
            return 0;
        }
        return ans;
    }
};