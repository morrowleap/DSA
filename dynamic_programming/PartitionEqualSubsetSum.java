package dynamic_programming;

import java.util.Scanner;

class PartitionEqualSubsetSumSolution {
    private boolean topDown(int[] nums, int target) {
        int n = nums.length;
        Boolean[][] memo = new Boolean[n][target + 1];
        return topDownHelper(nums, n - 1, target, memo);
    }

    private boolean topDownHelper(int[] nums, int n, int target, Boolean[][] memo) {
        if (target == 0) {
            return true;
        }

        if (n == 0) {
            return target == nums[0];
        }

        if (memo[n][target] != null) {
            return memo[n][target];
        }

        boolean pick = false;
        if (nums[n] <= target) {
            pick = topDownHelper(nums, n - 1, target - nums[n], memo);
        }
        boolean notPick = topDownHelper(nums, n - 1, target, memo);

        memo[n][target] = pick || notPick;
        return memo[n][target];
    }

    private boolean bottomUp(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= target; k++) {
                boolean pick = false;
                if (nums[i] <= k) {
                    pick = dp[i - 1][k - nums[i]];
                }
                boolean notPick = dp[i - 1][k];
                dp[i][k] = pick || notPick;
            }
        }

        return dp[n - 1][target];
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 0) {
            int target = sum / 2;
            topDown(nums, target);
            return bottomUp(nums, target);
        } else {
            return false;
        }
    }
}

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        PartitionEqualSubsetSumSolution sol = new PartitionEqualSubsetSumSolution();
        System.out.println(sol.canPartition(nums));

        sc.close();
    }
}
