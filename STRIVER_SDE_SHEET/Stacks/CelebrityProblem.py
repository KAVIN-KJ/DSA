def celebrity(mat):
        n = len(mat)
        top = 0
        down = n-1
        while top<down:
            if mat[top][down]==1:
                top+=1
            else:
                down-=1
            
        for i in range(n):
            if i!=top and (mat[i][top]==0 or mat[top][i]==1): return -1 
        return top
    
