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

# inorder
def morrisTraverseInorder(root):
    if root is None: return []
    ans = []
    cur = root
    while cur:
        if cur.left is None:
           ans.append(cur.val)
           cur = cur.right
        else:
            pred = cur.left
            while pred.right and pred.right is not cur:
                pred = pred.right
            if pred.right is None:
                pred.right = cur
                cur = cur.left
            else:
                pred.right = None
                ans.append(cur.val)
                cur = cur.right
    return ans


# preorder
def morrisTraversePreorder(root):
    if root is None: return []
    ans = []
    cur = root
    while cur:
        if cur.left is None:
            ans.append(cur.val)
            cur = cur.right
        else:
            pred = cur.left
            while pred.right and pred.right is not cur:
                    pred = pred.right
            if pred.right is None:
                pred.right = cur
                ans.append(cur.val)
                cur = cur.left
            else:
                pred.right = None
                cur = cur.right
    return ans


root = None
while True:
    x = int(input())
    if x==-1:
        break
    root = insert(root,x)

arr = morrisTraverseInorder(root)

print(arr)

arr = morrisTraversePreorder(root)

print(arr)