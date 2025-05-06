/*
 * https://takeuforward.org/data-structure/sudoku-solver/
 * https://youtu.be/FWAIf_EVUKE
 * 
 * https://leetcode.com/problems/sudoku-solver/description/
*/

package recursion;

public class SudokoSolver {

    boolean isValid(char[][] board, int x, int y, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == c || board[i][y] == c)
                return false;
        }
        int m = (x / 3) * 3, n = (y / 3) * 3;
        for (int i = m; i < m + 3; i++) {
            for (int j = n; j < n + 3; j++) {
                if (board[i][j] == c)
                    return false;
            }
        }
        return true;
    }

    boolean dfs(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (dfs(board))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        SudokoSolver sol = new SudokoSolver();
        sol.solveSudoku(board);
        for (char[] row : board) {
            for (char c : row)
                System.out.print(c + " ");
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        dfs(board);
    }
}
