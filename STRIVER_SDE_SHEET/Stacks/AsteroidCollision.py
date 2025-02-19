
def asteroidCollision(ast: list[int]) -> list[int]:
    stk = []  # only saved asteroids will be stored in the stack
    for i in ast:
        if(i>0): stk.append(i) #Positive value encountered push it to stack asteroid moving right
        else:  # asteroid moving left
            val = abs(i) #get the magnitude of the asteroid
            while stk and stk[-1]>0: #if stack is not empty and there exists a right moving asteroid
                
                if stk[-1]<val: # if the left moving asteroid is larger than right moving asteroid, Destry the right moving asteroid
                    stk.pop()
                    continue # continue to check if there exists another smaller asteroid moving right
                if(stk[-1]==val): # if both are equal =, then both are destroyed
                    stk.pop() 
                    break
                else: # if the left moving asteroid is smaller than right moving asteroid, it gets destroyed
                    break
            else: # if stack is not empty or all the elements in the stack are left moving asteroids then append current asteroid to the stack
                stk.append(i)
    return stk