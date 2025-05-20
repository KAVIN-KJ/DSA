
# creating an empty set
Set = list()

while True:
    x = int(input())
    if x<0: break
    Set.append(x)

for i in Set:
    print(i,end=" ")

# creating an empty hashmap

mymap = dict()

# Let's find the occurrence of each element in a list 

for i in Set:
    mymap[i] = mymap.get(i,0)+1

for key,val in mymap.items():
    print(key,":",val)