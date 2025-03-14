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
            if(target == 0 && nums[0] == 0) {return 2;}
            if(target == 0 || nums[0] == target) {return 1;}
            return 0;
        }

        if(memo[n][target] != null) {
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
        System.out.println(sol.topDown(nums, target));

        sc.close();
    }
}
