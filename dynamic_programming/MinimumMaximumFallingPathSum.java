/*
 * https://takeuforward.org/data-structure/minimum-maximum-falling-path-sum-dp-12/
 * https://leetcode.com/problems/minimum-falling-path-sum/description/
*/

package dynamic_programming;

import java.util.Scanner;

class MinimumFallingPathSumSolution {
    private int topDownHelper(int[][] matrix, int row, int col, int[][] memo) {
        int n = matrix.length;

        if(row == n - 1) {
            return matrix[row][col];
        }

        if(memo[row][col] != -1) {
            return memo[row][col];
        }
        
        int mini = Integer.MAX_VALUE;
        if(row + 1 < n && col - 1 >= 0) {
            mini = Math.min(mini, topDownHelper(matrix, row + 1, col - 1, memo));
        }
        if(row + 1 < n && col < n) {
            mini = Math.min(mini, topDownHelper(matrix, row + 1, col, memo));
        }
        if(row + 1 < n && col + 1 < n) {
            mini = Math.min(mini, topDownHelper(matrix, row + 1, col + 1, memo));
        }

        memo[row][col] = matrix[row][col] + mini;
        return memo[row][col];
    }

    public int topDown(int[][] matrix) {
        int n = matrix.length;
        int[][] memo = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                memo[i][j] = -1;
            }
        }

        int mini = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            mini = Math.min(mini, topDownHelper(matrix, 0, i, memo));
        }
        return mini;
    }

    public int bottomUp(int[][] matrix) {
        int n = matrix.length;
        int[][] memo = new int[n][n];

        for(int col=0;col<n;col++) {
            memo[n - 1][col] = matrix[n - 1][col];
        }

        for(int row = n - 2; row >= 0; row--) {
            for(int col = 0; col < n; col++) {
                int mini = Integer.MAX_VALUE;
                if(row + 1 < n && col - 1 >= 0) {
                    mini = Math.min(mini, memo[row + 1][col - 1]);
                }
                if(row + 1 < n && col < n) {
                    mini = Math.min(mini, memo[row + 1][col]);
                }
                if(row + 1 < n && col + 1 < n) {
                    mini = Math.min(mini, memo[row + 1][col + 1]);
                }

                memo[row][col] = matrix[row][col] + mini;
            }
        }

        int mini = Integer.MAX_VALUE;
        for(int col = 0; col < n; col++) {
            mini = Math.min(mini, memo[0][col]);
        }
        return mini;
    }
}

public class MinimumMaximumFallingPathSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        MinimumFallingPathSumSolution sol = new MinimumFallingPathSumSolution();
        System.out.println(sol.topDown(matrix));
        System.out.println(sol.bottomUp(matrix));

        sc.close();
    }
}