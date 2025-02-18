n = int(input())
arr = []
fact = 1
for i in range(1,n):
    fact*=i
    arr.append(i)
arr.append(n)

k = int(input())
k-=1
ans = ""
while True:
    ans+=str(arr[int(k/fact)])
    arr.pop(int(k/fact))
    if not arr: break
    k %=fact
    fact =int(fact/len(arr))

print(ans)