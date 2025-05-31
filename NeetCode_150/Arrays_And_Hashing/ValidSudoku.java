import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> st = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String row = "row" + i + board[i][j];
                    String col = "col" + j + board[i][j];
                    String box = "box (" + (i / 3) + ", " + (j / 3) + ")" + board[i][j];
                    if (!st.add(row) || !st.add(col) || !st.add(box))
                        return false;
                }
            }
        }
        return true;
    }
}
