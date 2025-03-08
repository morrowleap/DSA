package dynamic_programming;

import java.util.Scanner;

class Solution {
    private int topDownHelper(int n, int[] nums, int[] memo) {
        if(n < 0) {
            return 0;
        }

        if(memo[n] != -1) {
            return memo[n];
        }

        int pick = nums[n] + topDownHelper(n - 2, nums, memo);
        int notPick = topDownHelper(n - 1, nums, memo);

        memo[n] = Math.max(pick, notPick);
        return memo[n];
    }

    public int topDown(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        for(int i=0;i<n;i++) {memo[i] = -1;}
        return topDownHelper(n - 1, nums, memo);
    }

    public int bottomUp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for(int i=0;i<n;i++) {
            int pick = nums[i];
            if(i - 2 >= 0) {
                pick += dp[i - 2];
            }

            int notPick = 0;
            if(i - 1 >= 0) {
                notPick += dp[i - 1];
            }

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }
}

public class HouseRobber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) {
            nums[i] = scanner.nextInt();
        }

        Solution sol = new Solution();
        System.out.println(sol.topDown(nums));
        System.out.println(sol.bottomUp(nums));

        scanner.close();
    }
}
