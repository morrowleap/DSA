/*
 * https://takeuforward.org/data-structure/rotten-oranges-min-time-to-rot-all-oranges-bfs/
 * https://leetcode.com/problems/rotting-oranges/description/
 * https://youtu.be/yf3oUhkvqA0?list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw
*/

package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        // We have to do bfs over all the rotten oranges tha are currently present
        // currently

        // iterate over the grid put the rotten oranges in the queue

        // at the end the level-1 of bfs will be the time taken to rot all.

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        int level = bfs(queue, visited, grid);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return level;
    }

    private int bfs(Queue<int[]> queue, boolean[][] visited, int[][] grid) {
        // Now we have to do bfs from multiple sources simultaneously
        int level = 0;
        while (!queue.isEmpty()) {
            int q_count = queue.size();

            for (int i = 0; i < q_count; i++) {
                int[] u = queue.remove();

                // Add neighbours to the queue
                addNbr(u, queue, visited, grid);
            }

            if (!queue.isEmpty()) {
                level++;
            }
        }

        return level;
    }

    private void addNbr(int[] u, Queue<int[]> queue, boolean[][] visited, int[][] grid) {
        int x = u[0], y = u[1];

        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { -1, 0, 1, 0 };

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];

            if (newx >= 0 && newy >= 0 && newx < m && newy < n) {
                if (!visited[newx][newy] && grid[newx][newy] != 0) {
                    grid[newx][newy] = 2;
                    queue.add(new int[] { newx, newy });
                    visited[newx][newy] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] grid1 = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        int[][] grid2 = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        int[][] grid3 = { { 0 } };

        RottenOranges sol = new RottenOranges();
        System.out.println(sol.orangesRotting(grid1));
        System.out.println(sol.orangesRotting(grid2));
        System.out.println(sol.orangesRotting(grid3));

        sc.close();
    }
}
