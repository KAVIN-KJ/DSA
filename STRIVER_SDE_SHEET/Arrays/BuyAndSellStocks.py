n = int(input("Enter No of elements :"))
arr = []
for i in range(n):
    arr.append(int(input()))
mn = arr[0]
profit = 0
for i in range(n):
    profit = max(profit,arr[i]-mn)
    mn = min(mn,arr[i])
print("Maxinum Profit:",profit)
    