package Random_Revision;
import java.util.*;
public class WordSearch {
    public static boolean exist(char[][] grid, String word) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(check(grid,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean check(char grid[][], int i,int j, String word,int ind){
        if(ind==word.length()){
            return true;
        }
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||word.charAt(ind)!=grid[i][j]){
            return false;
        }
        char temp = grid[i][j];
        grid[i][j] = '#';
        boolean res =   check(grid,i+1,j,word,ind+1)||
                check(grid,i-1,j,word,ind+1)||
                check(grid,i,j+1,word,ind+1)||
                check(grid,i,j-1,word,ind+1);
        grid[i][j] = temp;
        return res;
    }
}