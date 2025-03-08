package dynamic_programming;
import java.util.Scanner;

class Solution {
    private int topDownHelper(int row, int col1, int col2, int[][] grid, int[][][] memo) {
        int m = grid.length;
        int n = grid[0].length;

        if (row == m - 1) {
            if (col1 == col2) {
                return grid[row][col1];
            } else {
                return grid[row][col1] + grid[row][col2];
            }
        }

        if (memo[row][col1][col2] != -1) {
            return memo[row][col1][col2];
        }

        int maxi = Integer.MIN_VALUE;
        for (int dc1 = -1; dc1 <= 1; dc1++) {
            for (int dc2 = -1; dc2 <= 1; dc2++) {
                int ncol1 = dc1 + col1;
                int ncol2 = dc2 + col2;
                if (ncol1 >= 0 && ncol1 < n && ncol2 >= 0 && ncol2 < n) {
                    int value = topDownHelper(row + 1, ncol1, ncol2, grid, memo);
                    if (col1 == col2) {
                        value += grid[row][col1];
                    } else {
                        value += grid[row][col1] + grid[row][col2];
                    }
                    maxi = Math.max(value, maxi);
                }
            }
        }

        memo[row][col1][col2] = maxi;
        return maxi;
    }

    public int topDown(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] memo = new int[m][n][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        int i = 0, j1 = 0, j2 = n - 1;
        return topDownHelper(i, j1, j2, grid, memo);
    }

    public int bottomUp(int grid[][]) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] memo = new int[m][n][n];

        int row = m - 1;
        for (int col1 = 0; col1 < n; col1++) {
            for (int col2 = 0; col2 < n; col2++) {
                if (col1 == col2) {
                    memo[row][col1][col2] = grid[row][col1];
                } else {
                    memo[row][col1][col2] = grid[row][col1] + grid[row][col2];
                }
            }
        }

        for (row = m - 2; row >= 0; row--) {
            for (int col1 = 0; col1 < n; col1++) {
                for (int col2 = 0; col2 < n; col2++) {

                    int maxi = Integer.MIN_VALUE;

                    for (int dc1 = -1; dc1 <= 1; dc1++) {
                        for (int dc2 = -1; dc2 <= 1; dc2++) {
                            int ncol1 = col1 + dc1;
                            int ncol2 = col2 + dc2;

                            if (ncol1 >= 0 && ncol1 < n && ncol2 >= 0 && ncol2 < n) {
                                int value = memo[row + 1][ncol1][ncol2];
                                if (col1 == col2) {
                                    value += grid[row][col1];
                                } else {
                                    value += grid[row][col1] + grid[row][col2];
                                }
                                maxi = Math.max(value, maxi);
                            }
                        }
                    }

                    memo[row][col1][col2] = maxi;
                }
            }
        }

        return memo[0][0][0] + memo[0][n - 1][n - 1];
    }
}

public class ChocolatesPickup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                grid[row][col] = sc.nextInt();
            }
        }

        Solution sol = new Solution();
        System.out.println(sol.topDown(grid));
        System.out.println(sol.bottomUp(grid));

        sc.close();
    }
}