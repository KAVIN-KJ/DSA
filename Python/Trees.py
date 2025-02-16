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