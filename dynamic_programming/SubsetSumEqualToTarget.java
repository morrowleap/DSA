package dynamic_programming;

import java.util.Scanner;

class SubsetSumSolution {
    public Boolean topDown(int[] nums, int target) {
        int n = nums.length;
        Boolean[][] memo = new Boolean[n][target + 1];
        return topDownHelper(nums, n - 1, target, memo);
    }

    private Boolean topDownHelper(int[] nums, int n, int target, Boolean[][] memo) {
        if (target == 0) {
            return true;
        }

        if (n == 0) {
            return nums[0] == target;
        }

        if (memo[n][target] != null) {
            return memo[n][target];
        }

        boolean pick = false;
        if(target - nums[n] >= 0) {
            pick = topDownHelper(nums, n - 1, target - nums[n], memo);
        }
        boolean notPick = topDownHelper(nums, n - 1, target, memo);

        memo[n][target] = pick || notPick;
        return memo[n][target];
    }

    public Boolean bottomUp(int[] nums, int target) {
        // Base Case 1: if at any point target is 1 return true
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if(nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                boolean pick = false;
                if(j - nums[i] >= 0) {
                    pick = dp[i - 1][j - nums[i]];
                }
                boolean notPick = dp[i - 1][j];

                dp[i][j] = pick || notPick;
            }
        }

        return dp[n - 1][target];
    }
}

public class SubsetSumEqualToTarget {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        SubsetSumSolution sol = new SubsetSumSolution();
        System.out.println(sol.topDown(nums, target));
        System.out.println(sol.bottomUp(nums, target));

        sc.close();
    }
}
