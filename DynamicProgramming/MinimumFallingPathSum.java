import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Solution {
    private int topDownHelper(int[][] matrix, int row, int col) {
        int n = matrix.length;

        if(row == n - 1) {
            return matrix[row][col];
        }
        
        int mini = Integer.MAX_VALUE;
        if(row + 1 < n && col - 1 >= 0) {
            mini = Math.min(mini, topDownHelper(matrix, row + 1, col - 1));
        }
        if(row + 1 < n && col < n) {
            mini = Math.min(mini, topDownHelper(matrix, row + 1, col));
        }
        if(row + 1 < n && col + 1 < n) {
            mini = Math.min(mini, topDownHelper(matrix, row + 1, col + 1));
        }

        return matrix[row][col] + mini;
    }

    public int topDown(int[][] matrix) {
        int n = matrix.length;
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            mini = Math.min(mini, topDownHelper(matrix, 0, i));
        }
        return mini;
    }
}

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        Solution sol = new Solution();
        System.out.println(sol.topDown(matrix));

        sc.close();
    }
}