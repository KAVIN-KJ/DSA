
def nextPerm(arr):
    n = len(arr)
    i = n-2
    while i>=0 and arr[i]>arr[i+1]:
       i-=1
    if i==-1:
        return arr[::-1]
    k = n-1
    while k>=i:
        if arr[k]>arr[i]:
            arr[i],arr[k] = arr[k],arr[i]
            break
        k-=1
    arr[i+1:] = arr[i+1:][::-1]
    return arr
    

arr = []
while 1:
    x = int(input())
    if x==-1: break
    arr.append(x)
    
print(nextPerm(arr))