class Solution:
    def modifyQueue(self, q, k):
        # code here
        s = []
        n = len(q)
        for i in range(k):
            s.append(q.popleft())
        while s:
            q.append(s.pop())
        for i in range(n-k):
            q.append(q.popleft())
        return q

