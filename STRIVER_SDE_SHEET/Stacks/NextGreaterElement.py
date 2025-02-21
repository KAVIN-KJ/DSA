def nge(arr):
    stk = []
    ans = [-1]*len(arr)
    for i in range(len(arr)-1,-1,-1):
        while stk and stk[-1]<=arr[i]:
            stk.pop()
        if stk:
          ans[i] = stk[-1]
        stk.append(arr[i])
    return ans

arr = []
while True:
    x = int(input()) 
    if x==-1: break
    arr.append(x)

print(nge(arr))