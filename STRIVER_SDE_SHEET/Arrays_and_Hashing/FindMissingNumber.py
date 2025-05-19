arr = []
n = int(input())
for i in range(n):
    arr.append(int(input()))

hash = [0]*(n+1)

for i in arr:
    hash[i]+=1
    
ans = None
for i in range(1,len(hash)+1):
    if hash[i]==0:
        ans=i
        break
print(ans) 