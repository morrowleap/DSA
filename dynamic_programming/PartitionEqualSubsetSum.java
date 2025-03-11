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
        if(nums[n] <= target) {
            pick = topDownHelper(nums, n - 1, target - nums[n], memo);
        }
        boolean notPick = topDownHelper(nums, n - 1, target, memo);

        memo[n][target] = pick || notPick;
        return memo[n][target];
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 0) {
            int target = sum / 2;
            return topDown(nums, target);
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
