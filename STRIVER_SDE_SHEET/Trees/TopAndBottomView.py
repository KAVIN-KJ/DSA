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


def bottomView(root):
        # code here
        mpp = {}
        q = [(root,0)]
        while q:
            curr,hd = q.pop(0)
            mpp[hd] = curr.val
            if(curr.right):
                q.append((curr.right,hd+1))
        return [mpp[k] for k in sorted(mpp.keys())]


def topView(root):
        # code here
        mpp = {}
        q = [(root,0)]
        while q:
            cur,hd = q.pop(0)
            if not mpp.get(hd):
                mpp[hd] = cur.val
            if cur.left:
                q.append((cur.left,hd-1))
            if cur.right:
                q.append((cur.right,hd+1))
        return [mpp[k] for k in sorted(mpp.keys())]



root = None
while True:
    x = int(input())
    if x==-1:
        break
    root = insert(root,x)
    
print(bottomView(root))

print(topView(root))