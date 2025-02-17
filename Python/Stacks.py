stack = list()

print("Appending to stack :")
while True:
    x = int(input())
    if x==-1: break
    stack.append(x)

print("Popping and printing from stack :")
while len(stack) !=0:
    print(stack.pop(0),end=" ")

print("stack after popping and printing",stack)
