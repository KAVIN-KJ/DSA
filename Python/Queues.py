que = list()

print("Adding to queue :")
while True:
    x = int(input())
    if(x==-1): break
    que.append(x)

print("Popping from queue :")
while que:
    print(que.pop(0),end=" ")

