def gcd(a,b):
    while b!=0:
        a,b = b,a%b
    return a



n = int(input())
sum = 0
for i in range(1,n+1):
    sum += ((i*n)//gcd(i,n))

print(sum)
    
