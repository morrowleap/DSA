import java.util.Scanner;
import java.util.Arrays;

class Solution {
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
}

public class UniquePaths2 {
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

        Solution sol = new Solution();
        System.out.println(sol.topDown(grid));

        scanner.close();
    }
}