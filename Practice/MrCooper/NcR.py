
def ncr(n,r):
    res = 1
    for i in range(r):
        res *= (n-i)
        res//= (i+1)
    return res


def pascalRow(r):
    ans = 1
    arr = []
    arr.append(ans)
    for i in range(1,r):
        ans *= (r-i)
        ans //= (i)
        arr.append(ans)
    return arr

def pascal(r):
    for i in range(1,r+1):
        print(pascalRow(i))

# n = int(input())
# r = int(input())

pascal(7)
print(pascalRow(8))
# print(ncr(n,r))
