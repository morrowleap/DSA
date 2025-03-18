/*
 * https://takeuforward.org/data-structure/grid-unique-paths-2-dp-9/
 * https://leetcode.com/problems/unique-paths-ii/description/
*/

package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

class UniquePaths2Solution {
    private int topDownHelper(int m, int n, int[][] grid, int[][] memo) {
        if(m < 0 || n < 0) {
            return 0;
        }

        if(grid[m][n] == 1) {
            return 0;
        }

        if(m == 0 && n == 0) {
            return 1;
        }

        if(memo[m][n] != -1) {
            return memo[m][n];
        }

        int up = topDownHelper(m - 1, n, grid, memo);
        int left = topDownHelper(m, n - 1, grid, memo);

        memo[m][n] = up + left;
        return up + left;
    }

    public int topDown(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] memo = new int[m][n];
        for(int[] rows: memo) {
            Arrays.fill(rows,  -1);
        }

        return topDownHelper(m - 1, n - 1, grid, memo);
    }

    public int bottomUp(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] memo = new int[m][n];

        if(grid[0][0] == 1) {
            return 0;
        }

        memo[0][0] = 1;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {

                if(i == 0 && j == 0) {
                    continue;
                }

                if(grid[i][j] == 1) {
                    memo[i][j] = 0;
                    continue;
                }

                int up = 0, left = 0;
                if(i - 1 >= 0 && grid[i - 1][j] != 1) {
                    up = memo[i - 1][j];
                }
                if(j - 1 >= 0 && grid[i][j - 1] != 1) {
                    left = memo[i][j - 1];
                }
                
                memo[i][j] = up + left;
            }
        }
        return memo[m - 1][n - 1];
    }
}

public class GridUniquePaths2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] grid = new int[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        UniquePaths2Solution sol = new UniquePaths2Solution();
        System.out.println(sol.topDown(grid));

        scanner.close();
    }
}