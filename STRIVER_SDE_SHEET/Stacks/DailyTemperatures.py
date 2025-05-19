'''

    similar to next greater element the only difference is
    that we push a tuple (value,index) to the stack
    and the current index of result will be index of top of the stack minus current index

    
'''
def dailyTemp(arr):
    st = []
    ans = [-1]*len(arr)
    for i in range(len(arr)-1,-1,-1):
        while st and st[-1][0]<=arr[i]:
            st.pop()
        if st:
            ans[i]=abs(i - st[-1][1])
        st.append((arr[i],i))
    return ans


arr = []
n =int(input())
for i in range(n):
    arr[i] = int(input(i))

