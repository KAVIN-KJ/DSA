
def isAnagram(s: str, t: str) -> bool:
    if len(s)!=len(t): return False

    ct,cs = {},{}

    for i in range(len(s)):
        ct[t[i]] = 1+ct.get(t[i],0)
        cs[s[i]] = 1+cs.get(s[i],0)
    return ct==cs

s = input()
t= input()

print(isAnagram(s,t))