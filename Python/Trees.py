class Node:
    data=0
    left=None
    right=None
    def __init__(self,val,left,right):
        self.data = val
        self.left = left
        self.right=right
    def __init__(self,val):
        self.data = val


def levelOrder(root):
    que = list()
    que.append(root)
    while(que):
        for i in range(0,len(que)):
            curr = que.pop(0)
            print(curr.data,end=" ")
            if curr.left is not None: que.append(curr.left)
            if curr.right is not None: que.append(curr.right)
        print()
                    


def insert(root,val):
    if(root==None):
        return Node(val)
    
    if(val < root.data):
        root.left = insert(root.left,val)
    elif val>=root.data:
        root.right = insert(root.right,val)
    
    return root

def display(root):
    if(root==None): return
    
    display(root.left)
    print(root.data,end=" ")
    display(root.right)

root = None
while True:
    x = int(input())
    if(x==-1): break
    root = insert(root,x)

display(root)
print()
levelOrder(root)