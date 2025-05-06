/*
 * https://takeuforward.org/data-structure/sudoku-solver/
 * https://youtu.be/FWAIf_EVUKE
 * 
 * https://leetcode.com/problems/sudoku-solver/description/
*/

package recursion;

public class SudokoSolver {
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
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (backtrack(board) == true) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        int N = board.length;

        for (int k = 0; k < N; k++) {
            if (i != k && board[k][j] == c) {
                return false;
            }
            if (j != k && board[i][k] == c) {
                return false;
            }
        }

        int m = (i / 3) * 3, n = (j / 3) * 3;
        for (int k = m; k < m + 3; k++) {
            for (int l = n; l < n + 3; l++) {
                if (board[k][l] == c) {
                    return false;
                }
            }
        }

        return true;
    }
}
