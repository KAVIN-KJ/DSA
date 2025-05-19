nums = [10,20,30,40,50,60,70]

print("Iterating through elements in a list ")
for i in nums:
    print(i,end=" ")

# if i = -1 nums[i] return the last number of the list    
i = int(input("\nEnter index : "))
print("Value at index",i,"is",nums[i])


print("Enter -1 to stop")

while True:
    x = int(input())
    if(x==-1): break
    nums.append(x)

for i in nums:
    print(i,end=" ")
print()

i,num = int(input("Enter index to be inserted : ")) , int(input("Enter number : "))
nums.insert(i,num)

for i in nums:
    print(i,end=" ")
print()

nums.pop()

print(nums.__len__())