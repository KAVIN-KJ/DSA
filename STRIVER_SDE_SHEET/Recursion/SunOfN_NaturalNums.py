def sumRecur(n):
    if n==1: return 1
    return n+sumRecur(n-1)

def print_N_to_one(n):
    if n<1: return
    print(n)
    print_N_to_one(n-1)
    print(n)

x = int(input("Enter N: "))
print(sumRecur(x))
print_N_to_one(x)