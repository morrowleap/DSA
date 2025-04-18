/*
 * G-8. Number of Islands | Number of Connected Components in Matrix | C++ | Java
 * https://takeuforward.org/data-structure/number-of-islands/
 * https://youtu.be/muncqlKJrH0
 * https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1
*/

package graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public int countIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'L' && !visited[i][j]) {
                    bfs(i, j, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int x, int y, char[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y });
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] point = queue.remove();
            x = point[0];
            y = point[1];

            // Visit neighbors in all 8 directions
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    int newx = x + dx;
                    int newy = y + dy;

                    if (newx >= 0 && newy >= 0 && newx < m && newy < n && grid[newx][newy] == 'L'
                            && !visited[newx][newy]) {
                        queue.add(new int[] { newx, newy });
                        visited[newx][newy] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char grid1[][] = { { 'L', 'L', 'W', 'W', 'W' }, { 'W', 'L', 'W', 'W', 'L' }, { 'L', 'W', 'W', 'L', 'L' },
                { 'W', 'W', 'W', 'W', 'W' }, { 'L', 'W', 'L', 'L', 'W' } };

        char grid2[][] = { { 'W', 'L', 'L', 'L', 'W', 'W', 'W' }, { 'W', 'W', 'L', 'L', 'W', 'L', 'W' } };

        NumberOfIslands sol = new NumberOfIslands();
        System.out.println(sol.countIslands(grid1));
        System.out.println(sol.countIslands(grid2));
    }
}
