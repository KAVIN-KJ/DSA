# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root):
        if root==None:
            return 0
        def lvorder():
            count=0
            q = []
            q.append(root)
            while q:
                n = len(q)
                for i in range(n):
                    cur = q.pop(0)
                    if(cur.left): q.append(cur.left)
                    if cur.right: q.append(cur.right)
                count+=1
            return count

        return lvorder()
                    