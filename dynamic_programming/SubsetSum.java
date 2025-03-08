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

        if (n < 0 || target < 0) {
            return false;
        }

        if (memo[n][target] != null) {
            return memo[n][target];
        }

        boolean pick = topDownHelper(nums, n - 1, target - nums[n], memo);
        boolean notPick = topDownHelper(nums, n - 1, target, memo);

        memo[n][target] = pick || notPick;
        return memo[n][target];
    }
}

public class SubsetSum {
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

        sc.close();
    }
}
