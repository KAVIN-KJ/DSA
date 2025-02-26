class MinStack:

    def __init__(self):
        self.stk = []
        self.mini = 0

    def push(self, val: int) -> None:
        if not self.stk:
            self.stk.append((val,val))
        else:
            self.stk.append((val,min(val,self.stk[-1][1])))
            
    def pop(self) -> None:
        self.stk.pop()

    def top(self) -> int:
        return self.stk[-1][0]

    def getMin(self) -> int:
        return self.stk[-1][1]

mnstk = MinStack()
while True:
    x = int(input("1.Push\n2.Pop\n3.Top\n4.Get Min\n-1.break\nEnter your choice : "))
    if x==-1: break
    elif x==1:
        val = int(input("Value : "))
        mnstk.push(val)
    elif x==2:
        mnstk.pop()
    elif x==3:
       print("Top Element",mnstk.top())
    elif x==4:
        print("Minimum ELement",mnstk.getMin())
    