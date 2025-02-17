def combinationSum2(i,arr,curr,ans,trgt):
    if trgt==0:
        ans.append(curr[:])
    if trgt<0 or i==len(arr):return
    for j in range(i,len(arr)):
        if(j>i and arr[j]==arr[j-1]): continue
        curr.append(arr[j])
        combinationSum2(j+1,arr,curr,ans,trgt-arr[j])
        curr.pop()


def combinationSum(i,arr,curr,ans,trgt):
    if trgt==0:
        ans.append(curr[:])
    if(trgt<0 or i==len(arr)):
        return
    for j in range(i,len(arr)):
        if j>i and arr[j] == arr[j-1]: continue
        curr.append(arr[j])
        combinationSum(j,arr,curr,ans,trgt-arr[j])
        curr.pop()


arr = []
while True:
    x = int(input())
    if(x==-1): break
    arr.append(x)

arr.sort()
ans = []
curr = []
trgt = int(input("Enter Target vakue : "))
combinationSum2(0,arr,curr,ans,trgt)
print("Combinations with unique elements resulting target",trgt)
for i in ans:
    print(i)

combinationSum(0,arr,curr,ans,trgt)
print("Combinations with non-unique elements resulting target",trgt)
for i in ans:
    print(i)