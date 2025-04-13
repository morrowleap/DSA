/*
 * https://takeuforward.org/data-structure/word-search-leetcode/
 * https://leetcode.com/problems/word-search/description/
*/

package recursion;

public class WordSearch {

    private int[] roww = new int[] { 1, -1, 0, 0 };
    private int[] coll = new int[] { 0, 0, -1, 1 };

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;

        // TODO: Add recursion tree
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        int m = board.length;
        int n = board[0].length;

        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }

        if (board[i][j] == word.charAt(index)) {
            board[i][j] = '#';
            for (int d = 0; d < 4; d++) {
                int newi = i + roww[d];
                int newj = j + coll[d];
                if (dfs(board, newi, newj, word, index + 1)) {
                    return true;
                }
            }
            board[i][j] = word.charAt(index);
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };

        String word = "ABCCED";

        WordSearch sol = new WordSearch();
        System.out.println(sol.exist(board, word));
    }
}

// Time Complexity: O(m * n * 4^L)
// Space Complexity: O(L)
