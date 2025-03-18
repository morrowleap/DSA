/*
 * https://takeuforward.org/data-structure/count-partitions-with-given-difference-dp-18/
 * https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=partitions-with-given-difference
*/

package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

class CountPartitionsWithGivenDifferenceSolution {
    public int topDown(int[] nums, int diff) {
        int n = nums.length;

        int totalSum = Arrays.stream(nums).sum();

        if ((totalSum - diff) >= 0 && (totalSum - diff) % 2 == 0) {
            int target = (totalSum - diff) / 2;

            int[][] memo = new int[n][target + 1];
            for (int[] row : memo)
                Arrays.fill(row, -1);

            return topDownHelper(nums, n - 1, target, memo);
        } else {
            return 0;
        }
    }

    private int topDownHelper(int[] nums, int n, int target, int[][] memo) {
        if (n == 0) {
            if (target == 0 && nums[0] == 0) {
                return 2;
            }
            if (target == 0 || nums[0] == target) {
                return 1;
            }
            return 0;
        }

        if (memo[n][target] != -1) {
            return memo[n][target];
        }

        int notPick = topDownHelper(nums, n - 1, target, memo);
        int pick = 0;
        if (nums[n] <= target) {
            pick = topDownHelper(nums, n - 1, target - nums[n], memo);
        }

        memo[n][target] = notPick + pick;
        return memo[n][target];
    }

    public int bottomUp(int[] nums, int diff) {
        int n = nums.length;

        int totalSum = Arrays.stream(nums).sum();

        if ((totalSum - diff) >= 0 && (totalSum - diff) % 2 == 0) {
            int target = (totalSum - diff) / 2;

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
                    dp[i][k] = notPick + pick;
                }
            }

            return dp[n - 1][target];
        } else {
            return 0;
        }
    }
}

public class CountPartitionsWithGivenDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int diff = sc.nextInt();

        CountPartitionsWithGivenDifferenceSolution sol = new CountPartitionsWithGivenDifferenceSolution();
        System.out.println(sol.bottomUp(nums, diff));

        sc.close();
    }
}
