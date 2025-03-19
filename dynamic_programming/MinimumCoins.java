/*
 * https://takeuforward.org/data-structure/minimum-coins-dp-20/
 * https://leetcode.com/problems/coin-change/description/
*/

package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

class MinimumCoinsSolution {

    public int topDown(int[] coins, int amount) {
        int n = coins.length;

        int[][] memo = new int[n][amount + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        int count = topDownHelper(coins, n - 1, amount, memo);
        if (count == Integer.MAX_VALUE) {
            return -1;
        } else {
            return count;
        }
    }

    private int topDownHelper(int[] coins, int n, int amount, int[][] memo) { // Return min coins for amount
        // Striver: For base case imagine an array of single element and a possible target
        if (n == 0) {
            if (amount == 0) {
                return 0;
            } else if (amount % coins[0] == 0) {
                return (int) (amount / coins[0]);
            } else {
                return Integer.MAX_VALUE;
            }
        }

        if (memo[n][amount] != -1) {
            return memo[n][amount];
        }

        int notPick = topDownHelper(coins, n - 1, amount, memo);
        int pick = Integer.MAX_VALUE;
        if (coins[n] <= amount) {
            int subRes = topDownHelper(coins, n, amount - coins[n], memo); // standing on same index
            // and picking same coin one ata time to make multiple combinations, not doing greedily
            // Striver: Whenever there is infinite supply or multiple use it will stand at the same index
            if (subRes != Integer.MAX_VALUE) {
                pick = 1 + subRes; // adding one ata time, otherwise it will be a greedy approach
            }
        }

        memo[n][amount] = Math.min(pick, notPick);
        return memo[n][amount];
    }

    public int bottomUp(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int k = 0; k <= amount; k++) {
            if (k % coins[0] == 0) {
                dp[0][k] = (int) (k / coins[0]);
            } else {
                dp[0][k] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;

        for (int i = 1; i < n; i++) {
            for (int k = 0; k <= amount; k++) {
                int notPick = dp[i - 1][k];
                int pick = Integer.MAX_VALUE;
                if (coins[i] <= k) {
                    int subRes = dp[i][k - coins[i]];
                    if (subRes != Integer.MAX_VALUE) {
                        pick = 1 + subRes;
                    }
                }

                dp[i][k] = Math.min(notPick, pick);
            }
        }

        int count = dp[n - 1][amount];

        if (count == Integer.MAX_VALUE) {
            return -1;
        } else {
            return count;
        }
    }
}

public class MinimumCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        MinimumCoinsSolution sol = new MinimumCoinsSolution();
        System.out.println(sol.bottomUp(nums, k));

        sc.close();
    }
}