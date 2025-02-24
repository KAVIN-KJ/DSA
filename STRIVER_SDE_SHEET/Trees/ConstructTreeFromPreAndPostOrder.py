class TreeNode:
    def __init__(self,val):
        self.val = val
    def __init__(self,val,left,right):
        self(val)
        self.right = right
        self.left = left

class Solution:
    def constructFromPrePost(self, preorder, postorder):
        
        """_summary_
            
                postorder traversal has the following order = [left,right,root]
                so pop root first
                preorder has the following order = [root,left,right]
                if last value of preorder is not a right node i.e 
                (node.val!=preorder(-1)) -> the first if statement
                then start constructing the right subtree
                similarly do the same for ledt subtree
                and pop out the last element in the preorder list since the node has been processed
                return the node
                
        """
        
        def insert():
            node = TreeNode(postorder.pop())

            if node.val!=preorder[-1]:
                node.right = insert()
            if node.val!=preorder[-1]:
                node.left = insert()
            preorder.pop()
            return node
        return insert()