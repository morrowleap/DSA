/*
 * https://www.youtube.com/watch?v=GqOmJHQZivw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=20
 * https://takeuforward.org/data-structure/0-1-knapsack-dp-19/
 * https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
 * 
*/

package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

class ZeroOneKnapsackProblemSol {

    public int topDown(int w, int[] val, int[] wt) {
        int n = val.length;
        int[][] memo = new int[n][w + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return topDownHelper(w, n - 1, val, wt, memo);
    }

    private int topDownHelper(int w, int n, int[] val, int[] wt, int[][] memo) { // Maximum amount of value
        if (n == 0) {
            if (wt[0] <= w) {
                return val[0];
            } else {
                return 0;
            }
        }

        if (memo[n][w] != -1) {
            return memo[n][w];
        }

        int pick = Integer.MIN_VALUE;
        if (wt[n] <= w) {
            pick = val[n] + topDownHelper(w - wt[n], n - 1, val, wt, memo);
        }
        int notpick = topDownHelper(w, n - 1, val, wt, memo);

        memo[n][w] = Math.max(pick, notpick);
        return memo[n][w];
    }

    public int bottomUp(int w, int[] val, int[] wt) {
        int n = val.length;
        int[][] dp = new int[n][w+1];

        // Base Case:
        // At n=0, whatever the knapsack weight be if it is < wt[0], we get val[0]
        for(int k=0;k<=w;k++) {
            if(wt[0] <= k) {
                dp[0][k] = val[0];
            }
        }

        // Now claculate for n > 1
        for(int i=1;i<n;i++) {
            for(int j=0;j<=w;j++) {
                int pick = Integer.MIN_VALUE;
                if (wt[i] <= j) {
                    pick = val[i] + dp[i - 1][j - wt[i]];
                }
                int notpick = dp[i - 1][j];

                dp[i][j] = Math.max(pick, notpick);
            }
        }

        return dp[n - 1][w];
    }

}

public class ZeroOneKnapsackProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        int W = sc.nextInt();

        ZeroOneKnapsackProblemSol sol = new ZeroOneKnapsackProblemSol();
        System.out.println(sol.topDown(W, val, wt));

        sc.close();
    }
}
