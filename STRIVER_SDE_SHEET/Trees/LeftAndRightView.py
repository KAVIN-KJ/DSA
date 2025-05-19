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


def rightView(root):
    if not root: return []
    ans = []
    q = []
    q.append(root)
    while q:
        n = len(q)
        val = 0
        for i in range(n):
            cur = q.pop(0)
            if cur.left: q.append(cur.left)
            if cur.right: q.append(cur.right)
            val = cur.val
        ans.append(val)
    return ans

root = None
while True:
    x = int(input())
    if x==-1:
        break
    root = insert(root,x)

print(rightView(root))