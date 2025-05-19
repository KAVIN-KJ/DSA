n = int(input("Enter value of N "))
print("N is : ",n)
print("From 0 to ",n-1)

# prints from '0' to n-1 if : range(0,n)
# also range(0,n,2) -> 3rd parameter refers to increment count by 2
for i in range(0,n):
    print(i,end=",")

print("\nFrom 0 to ",n)

for i in range(0,n+1):
    print(i,end=",")

print("\n While Loop : ")

temp = 1
while temp<=n :
    if(temp%2==0):
        print(temp," - ","Even",end=" ")
    else:
        print(temp," - ","Odd",end=" ")
    temp+=1
    