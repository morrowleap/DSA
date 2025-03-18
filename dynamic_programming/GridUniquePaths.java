/*
 * https://takeuforward.org/data-structure/grid-unique-paths-dp-on-grids-dp8/
 * https://leetcode.com/problems/unique-paths/description/
*/

package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

class UniquePathsSolution {
    private int topDownHelper(int m, int n, int[][] memo) {
        if(m == 0 && n == 0) {
            return 1;
        }
        if(m < 0 || n < 0) {
            return 0;
        }

        if(memo[m][n] != -1) {
            return memo[m][n];
        }

        int up = topDownHelper(m - 1, n, memo);
        int left = topDownHelper(m, n - 1, memo);

        memo[m][n] = up + left;
        return up + left;
    }

    public int topDown(int m , int n) {
        int[][] memo = new int[m][n];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return topDownHelper(m - 1, n - 1, memo);
    }

    public int bottomUp(int m, int n) {
        int[][] memo = new int[m][n];

        memo[0][0] = 1;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                
                if(i == 0 && j == 0) {
                    continue;
                }

                int up = 0, left = 0;
                if(i - 1 >= 0) {
                    up = memo[i - 1][j];
                }
                if(j - 1 >= 0) {
                    left = memo[i][j - 1];
                }
                
                memo[i][j] = up + left;
            }
        }

        return memo[m - 1][n - 1];
    }
}

public class GridUniquePaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        UniquePathsSolution sol = new UniquePathsSolution();
        System.out.println(sol.topDown(m, n));
        System.out.println(sol.bottomUp(m, n));

        scanner.close();
    }
}