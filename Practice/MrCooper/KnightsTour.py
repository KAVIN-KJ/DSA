movex = [2,1,-1,-2,-2,-1,1,2]
movey = [1,2,2,1,-1,-2,-2,-1]

n = int(input())

def safe(x,y,n):
    return x>=0 and x<n and y>=0 and y<n and grid[x][y]==-1

def tour(x,y,move):
    if move==n*n:
        grid[x][y] = move
        return True
    for i in range(8):
        nx = x+movex[i]
        ny = y+movey[i]
        if safe(nx,ny,n):
            grid[nx][ny] = move
            if(tour(nx,ny,move+1)): return True
            grid[nx][ny] = -1
    return False


grid = [[-1 for _ in range(n)] for _ in range(n)]
grid[0][0] = 0
if tour(0,0,1):
    for i in grid:
        for j in i:
            print(j,end=" ")
        print()
else:
    print("No Solution")
