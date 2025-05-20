class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0){
            return false;
        }
        long num1=x;
        long num2=0;
        while(x!=0){
            num2+=(x%10);
            num2 = num2*10;
            x=x/10;
        }
        num2 = num2/10;
        return(num1==num2);
    }
};