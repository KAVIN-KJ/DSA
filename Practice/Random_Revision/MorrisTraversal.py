class Node:
    def __init__(self,x):
        self.val = x 
        self.left = self.right = None

def insert(root,x):
    if root is None:
        return Node(x)
    if x<root.val:
        root.left = insert(root.left,x)
    else:
        root.right = insert(root.right,x)
    
    return root


def morrisInorder(root):
    arr = []
    temp = root
    while temp:
        if not temp.left:
            arr.append(temp.val)
            temp = temp.right
        else:
            pred = temp.left
            while pred.right and pred.right is not temp:
                pred = pred.right
            if pred.right is None:
                pred.right = temp
                temp = temp.left
            else:
                pred.right = None
                arr.append(temp.val)
                temp = temp.right
    return arr


root = None
while True:
    x = int(input())
    if x==-1:
        break
    root = insert(root,x)

arr = morrisInorder(root)

print(arr)

# arr = morrisTraversePreorder(root)

# print(arr)