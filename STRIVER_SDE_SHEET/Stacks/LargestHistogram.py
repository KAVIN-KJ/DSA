def largestRectangleArea(arr):
    stk = []
    maxA = 0
    arr.append(0) # to make sure that even when last elements are increasing they are popped and processed
    for i,h in enumerate(arr):
        while stk and arr[stk[-1]]>h: #pop from stack as long as a smaller element is encountered
            height = arr[stk.pop()]
            width = i if not stk else (i-stk[-1]-1) #if stack is empty, the whole array traversed so far will form a rectangle else the normal width calculation
            maxA = max(maxA,height*width) #compute and store the max area
        stk.append(i) #append each element to the stack
    return maxA
    

arr = []
while True:
    x = int(input())
    if x==-1: break
    arr.append(x)
    