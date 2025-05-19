
def collision(arr):
    stk = []
    for i in arr:
        if i > 0: stk.append(i)
        else:
            val = abs(i)
            while stk and stk[-1]>0:
                if val > stk[-1]:
                    stk.pop()
                    continue
                elif val == stk[-1]:
                    stk.pop()
                    break
                else:
                    break
            else:
                stk.append(i)
    return stk




arr = []
while True:
    x = int(input())
    if x ==-1: break
    arr.append(x)

print(collision(arr))
