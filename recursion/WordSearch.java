/*
 * https://takeuforward.org/data-structure/word-search-leetcode/
 * 
 * https://leetcode.com/problems/word-search/description/
*/

package recursion;

public class WordSearch {
    public static void main(String[] args) {
        // char[][] board = {
        // { 'A', 'B', 'C', 'E' },
        // { 'S', 'F', 'C', 'S' },
        // { 'A', 'D', 'E', 'E' }
        // };
        // String word = "ABCCED";

        // char[][] board = {
        // { 'a', 'a' }
        // };
        // String word = "aaa";

        char[][] board = {
                { 'a' }
        };
        String word = "a";

        WordSearch sol = new WordSearch();
        System.out.println(sol.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {

        int firstChar = word.charAt(0);

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == firstChar) {
                    int[] coords = new int[] { i, j };
                    if (backtrack(word, 0, board, coords, visited) == true) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean backtrack(String word, int index, char[][] board, int[] coords, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        int i = coords[0], j = coords[1];
        int m = board.length, n = board[0].length;

        // Boundary and visited checks are performed after the base case to allow index
        // to reach word.length()
        // and to prevent out-of-bounds errors when the previous call moves coords
        // outside the grid.

        // This bieng done after entering dfs call is possibly called lazy DFS approach,
        // deferred validation, post-order boundary check
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return false;
        }

        if (word.charAt(index) == board[i][j]) {
            visited[i][j] = true;

            int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

            for (int[] delta : directions) {
                int newi = i + delta[0];
                int newj = j + delta[1];

                coords[0] = newi;
                coords[1] = newj;
                if (backtrack(word, index + 1, board, coords, visited) == true) {
                    return true;
                }
            }

            visited[i][j] = false;
        }

        return false;

        // TODO: Add recursion tree
    }
}

// Time Complexity: O(m * n * 4^L)
// Space Complexity: O(L)
