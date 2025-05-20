def letterCombinations(digits):
    keypad = {"0":" ","1":"","2":"abc","3":"def","4":"ghi","5":"jkl","6":"mno","7":"pqrs","8":"tuv","9":"wxyz"}
    result = []
    if digits=="" or digits=="1": return []
    def recurse(ind,curr):
        if ind==len(digits):
            result.append(curr)
            return
        for c in keypad[digits[ind]]: recurse(ind+1,curr+c)
    recurse(0,"")
    return result
    
s = input("Enter digits")
print(letterCombinations(s))