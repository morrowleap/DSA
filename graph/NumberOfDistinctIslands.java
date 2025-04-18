/*
 * Number of Distinct Islands (GFG)
 * https://youtu.be/7zmgQSJghpo?list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw
 * https://www.geeksforgeeks.org/problems/number-of-distinct-islands/0
*/

package graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class NumberOfDistinctIslands {

    int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    set.add(bfs(i, j, grid, visited));
                }
            }
        }

        return set.size();
    }

    private String bfs(int x, int y, int[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { x, y });
        visited[x][y] = true;

        int basex = x, basey = y;
        StringBuilder mapping = new StringBuilder();

        while (!queue.isEmpty()) {
            int[] point = queue.remove();
            x = point[0];
            y = point[1];

            mapping.append((x - basex) + "," + (y - basey) + ";");

            // Visit neighbors in all 4 directions
            int[] dx = { -1, 0, 1, 0 };
            int[] dy = { 0, -1, 0, 1 };
            for (int i = 0; i < 4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];

                if (newx >= 0 && newy >= 0 && newx < m && newy < n && grid[newx][newy] == 1
                        && !visited[newx][newy]) {
                    queue.add(new int[] { newx, newy });
                    visited[newx][newy] = true;
                }
            }
        }

        return mapping.toString();
    }

    public static void main(String[] args) {
        int grid1[][] = { { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 1, 1 } };

        int grid2[][] = { { 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 0, 1, 1 } };

        NumberOfDistinctIslands sol = new NumberOfDistinctIslands();
        System.out.println(sol.countDistinctIslands(grid1));
        System.out.println(sol.countDistinctIslands(grid2));
    }
}
