arr = []
n = int(input())
for i in range(n):
    arr.append(int(input()))

slow = arr[0]
fast = arr[0]

while True:
    slow = arr[slow]
    fast = arr[arr[fast]]
    if slow==fast: break

fast = arr[0]
while slow!=fast:
    slow = arr[slow]
    fast = arr[fast]

print("Duplicate element :",slow)