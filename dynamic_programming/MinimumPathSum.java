package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

class MinimumPathSumSolution {
    private int topDownHelper(int m, int n, int[][] grid, int[][] memo) {
        if(m == 0 && n == 0) {
            return grid[0][0];
        }

        if(m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }

        if(memo[m][n] != -1) {
            return memo[m][n];
        }

        int up = topDownHelper(m - 1, n, grid, memo);
        int left = topDownHelper(m, n - 1, grid, memo);

        memo[m][n] = grid[m][n] + Math.min(up, left);
        return memo[m][n];
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

        memo[0][0] = grid[0][0];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i == 0 && j == 0) {
                    continue;
                }

                int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;

                if(i - 1 >= 0) {
                    up = memo[i - 1][j];
                }
                if(j - 1 >= 0) {
                    left = memo[i][j - 1];
                }

                memo[i][j] = grid[i][j] + Math.min(up, left);
            }
        }

        return memo[m - 1][n - 1];
    }
}

public class MinimumPathSum {
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

        MinimumPathSumSolution sol = new MinimumPathSumSolution();
        System.out.println(sol.topDown(grid));
        System.out.println(sol.bottomUp(grid));
        
        scanner.close();
    }
}
