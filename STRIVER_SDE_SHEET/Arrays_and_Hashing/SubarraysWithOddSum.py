def numOfSubarrays(arr):
    prefix = 0
    odd = 0
    even = 1
    res = 0
    for i in arr:
        prefix+=i
        if prefix%2==0:
            res+=odd
            even+=1
        else:
            res+=even
            odd+=1
    return res%int(1e9+7)

arr = []
while True:
    x = int(input())
    if x==-1: break
    arr.append(x)
    
print(numOfSubarrays(arr))
    