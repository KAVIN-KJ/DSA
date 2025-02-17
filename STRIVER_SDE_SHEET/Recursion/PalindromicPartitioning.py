def helper(ind,s,curr,ans):
        if(ind==len(s)):
            ans.append(curr[:])
        for i in range(ind,len(s)):
            if(s[ind:i+1]==s[ind:i+1][::-1]):
                curr.append(s[ind:i+1])
                helper(i+1,s,curr,ans)
                curr.pop()
    
    
ans = []
curr = []
s = input()
helper(0,s,curr,ans)
for i in ans:
    print(i)

        