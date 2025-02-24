class Node:
    def __init__(self,x,key):
        self.val = x
        self.key - key
        self.prev = self.next = None


class LRUCache:
    
    def __init__(self,n):
        self.cap = n
        self.mpp = {}
        self.head = Node(-1)
        self.tail = Node(-1)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.tail.next = self.head.prev = None
    
    
    def addFront(self,node):
        node.next = self.head.next
        node.prev = self.head
        node.next.prev = node
        self.head.next = node
    
    def deleteNode(self,node):
        pre = node.prev
        nxt = node.next
        pre.next = nxt
        nxt.prev = pre
    
    def get(self,key):
        if key in self.mpp:
            node = self.mpp[key]
            self.deleleNode(node)
            self.addFront(node)
            return node.val
        else:
            return -1
    def put(self,key,value):
        if key in self.mpp:
            node = self.mpp[key]
            node.val = value
            self.deleteNode(node)
        else:
            if len(self.mpp)==self.cap:
                node = self.tail.prev
                self.deleteNode(node)
                del self.mpp[node.key]
            node = Node(key,value)
            self.mpp[key] = node
            self.addFront(node)