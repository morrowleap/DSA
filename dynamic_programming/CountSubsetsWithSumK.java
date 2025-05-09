/*
 * https://takeuforward.org/data-structure/count-subsets-with-sum-k-dp-17/
 * https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=perfect-sum-problem
*/

package dynamic_programming;

import java.util.Scanner;

class CountSubsetsWithSumKSolution {
    public int topDown(int[] nums, int target) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][target + 1];
        return topDownHelper(nums, n - 1, target, memo);
    }

    private int topDownHelper(int[] nums, int n, int target, Integer[][] memo) {
        if (n == 0) {
            if (target == 0 && nums[0] == 0) {
                return 2;
            }
            if (target == 0 || nums[0] == target) {
                return 1;
            }
            return 0;
        }

        if (memo[n][target] != null) {
            return memo[n][target];
        }

        int notPick = topDownHelper(nums, n - 1, target, memo);
        int pick = 0;
        if (nums[n] <= target) {
            pick = topDownHelper(nums, n - 1, target - nums[n], memo);
        }

        memo[n][target] = pick + notPick;
        return memo[n][target];
    }

    public int bottomUp(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        if (nums[0] == 0)
            dp[0][0] = 2; // 2 cases -pick and not pick
        else
            dp[0][0] = 1; // 1 case - not pick

        if (nums[0] != 0 && nums[0] <= target)
            dp[0][nums[0]] = 1; // 1 case -pick

        for (int i = 1; i < n; i++) {
            for (int k = 0; k <= target; k++) {
                int notPick = dp[i - 1][k];
                int pick = 0;
                if (nums[i] <= k) {
                    pick = dp[i - 1][k - nums[i]];
                }

                dp[i][k] = pick + notPick;
            }
        }

        return dp[n - 1][target];
    }
}

public class CountSubsetsWithSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        CountSubsetsWithSumKSolution sol = new CountSubsetsWithSumKSolution();
        System.out.println(sol.bottomUp(nums, target));

        sc.close();
    }
}
