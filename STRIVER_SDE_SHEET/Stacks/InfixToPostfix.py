

def precede(c):
    if c=='^': return 3
    elif c=='*' or c=='/': return 2
    elif c=='+' or c=='-': return 1
    else: return 0
    
def infixtopostfix(s):
    stk = []
    ans = ""
    for c in s:
        if (c>='a' and c<= 'z') or (c>='A' and c<='Z') or (c>='0' and c<='9'):
            ans+=c
        elif(c=='('):
            stk.append(c)
        elif c==')':
            while(stk and stk[-1]!='('):
                ans+=stk.pop()
            stk.pop()
        else:
            while(stk and precede(c)<=precede(stk[-1])):
                ans+=stk.pop()
            stk.append(c)
    while stk:
        ans+=stk.pop()
    return ans

print(infixtopostfix("a+b*(c^d-e)^(f+g*h)-i"))