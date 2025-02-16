def hello(name="KJKR"):
    print("Helloo!!",name)
    
    
    
def fibonacci(n):
    if n<=1: return n
    a,b = 0,1
    for _ in range(n):
        a=b
        b = a+b
        
    return a


names = ["Kavin","Jayabharathi","Karuppusamy","AJ","NSK"]
hello()
for name in names:
    hello(name)
    
x = int(input("Enter any number "))
for i in range(x):
    print(fibonacci(i),end=" ")