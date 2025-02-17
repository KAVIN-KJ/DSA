n = int(input())
arr = [0]*n
for i in range(n):
    arr[i] = int(input())

trgt = int(input())

ans = list()
arr.sort()
for i in range(n):
    if i>0 and arr[i]==arr[i-1]: continue
    for j in range(i+1,n):
        if(j>i+1 and arr[j]==arr[j-1]): continue
        k=j+1
        l=n-1
        while(k<l):
            sum = arr[i]+arr[j]+arr[k]+arr[l]
            if(sum<trgt):
                    k+=1
            elif sum>trgt:
                    l-=1
            else:
                temp = [arr[i],arr[j],arr[k],arr[l]]
                temp.sort()
                ans.append(list(temp))
                k+=1
                l-=1
                while k<l and arr[k]==arr[k-1]: k+=1
                while k<l and arr[l]==arr[l+1]: l-=1

for s in ans:
    print("[",s[0],s[1],s[2],s[3],"]")

                
                
        
