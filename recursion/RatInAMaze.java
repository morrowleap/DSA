/*
 * https://takeuforward.org/data-structure/rat-in-a-maze/
 * https://youtu.be/bLGZhJlt4y0
 * https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
*/

package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RatInAMaze {
    private final char[] moves = { 'R', 'D', 'L', 'U' };
    private final int[] dx = { 0, 1, 0, -1 };
    private final int[] dy = { 1, 0, -1, 0 };

    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        int n = mat.size();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = mat.get(i).get(j);
            }
        }
        ArrayList<String> result = (ArrayList<String>) findPath(matrix);
        Collections.sort(result);
        return result;
    }

    public List<String> findPath(int[][] matrix) {
        List<String> res = new ArrayList<>();
        int n = matrix.length;

        if (matrix[0][0] == 0 || matrix[n - 1][n - 1] == 0)
            return res;

        boolean[][] visited = new boolean[n][n];
        StringBuilder curr = new StringBuilder();

        dfs(matrix, 0, 0, curr, visited, res);
        return res;

        // TODO: Add recursion tree
    }

    private void dfs(int[][] matrix, int x, int y, StringBuilder curr, boolean[][] visited,
            List<String> res) {
        int n = matrix.length;
        if (x == n - 1 && y == n - 1) {
            res.add(curr.toString());
            return;
        }

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i], newY = y + dy[i];
            if (newX >= 0 && newX < n && newY >= 0 && newY < n && matrix[newX][newY] == 1 && !visited[newX][newY]) {
                curr.append(moves[i]);
                dfs(matrix, newX, newY, curr, visited, res);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
        visited[x][y] = false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 }
        };

        RatInAMaze sol = new RatInAMaze();
        System.out.println(sol.findPath(matrix));
    }
}

// Recursive Time Complexity: O(3^(n*n))
// Recursive Space Complexity: O(n*n)
