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

    private int topDownHelper(int[] coins, int n, int amount, int[][] memo) {
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
            int subRes = topDownHelper(coins, n, amount - coins[n], memo);
            if (subRes != Integer.MAX_VALUE) {
                pick = 1 + subRes;
            }
        }

        memo[n][amount] = Math.min(pick, notPick);
        return memo[n][amount];
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
        System.out.println(sol.topDown(nums, k));

        sc.close();
    }
}