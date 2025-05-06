/*
 * https://takeuforward.org/data-structure/rat-in-a-maze/
 * https://youtu.be/bLGZhJlt4y0
 * 
 * https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
*/

package recursion;

import java.util.ArrayList;
import java.util.Collections;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 }
        };

        RatInAMaze sol = new RatInAMaze();
        System.out.println(sol.ratInMaze(matrix));
    }

    private int[][] directions = {
            { -1, 0 },
            { 0, -1 }, { 0, 1 },
            { 1, 0 }
    };
    private char[] moves = { 'U', 'L', 'R', 'D' };;

    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();

        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        backtrack(maze, m, n, 0, 0, visited, curr, res);

        Collections.sort(res);
        return res;
    }

    private void backtrack(int[][] maze, int m, int n, int i, int j, boolean[][] visited, StringBuilder curr,
            ArrayList<String> res) {
        if (i < 0 || j < 0 || i >= m || j >= n || maze[i][j] == 0 || visited[i][j]) {
            return;
        }

        if (i == m - 1 && j == n - 1) {
            res.add(curr.toString());
            return;
        }

        visited[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int[] dir = directions[d];
            char move = moves[d];

            curr.append(move);
            backtrack(maze, m, n, i + dir[0], j + dir[1], visited, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
        visited[i][j] = false;
    }
}

// Recursive Time Complexity: O(3^(n*n))
// Recursive Space Complexity: O(n*n)
