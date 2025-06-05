/*
 * https://takeuforward.org/data-structure/rod-cutting-problem-dp-24/
 * https://www.geeksforgeeks.org/problems/rod-cutting0840/1
*/

// https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/description/?envType=daily-question&envId=2025-06-04

package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

class RodCuttingSol {
    public int topDown(int[] price) {
        int n = price.length;
        int[][] memo = new int[n + 1][n + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return topDownHelper(0, 0, n, price, memo);
    }

    private int topDownHelper(int start, int idx, int n, int[] price, int[][] memo) {
        if (start == n)
            return 0;
        if (idx == n)
            return price[n - start - 1];

        if (memo[idx][start] != -1) {
            return memo[idx][start];
        }

        int cut = Integer.MIN_VALUE;
        if (idx - start < n) {
            cut = price[idx - start] + topDownHelper(idx + 1, idx + 1, n, price, memo);
        }
        int notcut = topDownHelper(start, idx + 1, n, price, memo);

        memo[idx][start] = Math.max(cut, notcut);
        return memo[idx][start];
    }

    /*
     * This is a solution for rod cutting problem.
     * Tell the problem in this solution, dont give any other algoritm like 0/1
     * knapsack i want to do it my way.
     */
}

class RodCuttingSol2 {
    /*
     * In this solution we will consider the knapsack approach
     * where we have a bag of N weight.
     * and we have peices of several length from 1 to N.
     * We can put these pieces to complete the N weight, and maximize the prize;
     */

    public int topDown(int[] price) {
        int n = price.length;
        int[][] memo = new int[n + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return topDownHelper(price, n, n, memo);
    }

    private int topDownHelper(int[] price, int n, int w, int[][] memo) {
        if (n == 1) {
            if (w == 0) {
                return 0;
            } else {
                return ((int) (w / n)) * price[0];
            }
        }

        if (memo[n][w] != -1) {
            return memo[n][w];
        }

        int pick = Integer.MIN_VALUE;
        if (n <= w) {
            pick = price[n - 1] + topDownHelper(price, n, w - n, memo);
        }
        int notpick = topDownHelper(price, n - 1, w, memo);

        memo[n][w] = Integer.max(pick, notpick);
        return memo[n][w];
    }

    public int bottomUp(int[] price) {
        int n = price.length;

        int[][] dp = new int[n + 1][n + 1];

        dp[1][0] = 0;
        for (int w = 0; w <= n; w++) {
            dp[1][w] = ((int) (w / 1)) * price[0];
        }

        for (int i = 2; i <= n; i++) {
            for (int w = 0; w <= n; w++) {
                int pick = Integer.MIN_VALUE;
                if (i <= w) {
                    pick = price[i - 1] + dp[i][w - i];
                }
                int notpick = dp[i - 1][w];

                dp[i][w] = Integer.max(pick, notpick);
            }
        }

        return dp[n][n];
    }
}

public class RodCutting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        sc.close();
    }
}
