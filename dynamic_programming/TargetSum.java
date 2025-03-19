/*
 * https://takeuforward.org/data-structure/target-sum-dp-21/
 * https://leetcode.com/problems/target-sum/description/
*/

package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

class TargetSumSolution1 {

    public int topDown(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int offset = Math.abs(sum);

        if (Math.abs(target) > offset) {
            return 0;
        }

        Integer[][] memo = new Integer[n][2 * offset + 1];
        return topDownHelper(nums, n - 1, target, memo, offset);
    }

    private int topDownHelper(int[] nums, int n, int target, Integer[][] memo, int offset) {
        if (n == 0) {
            int count = 0;
            if (target - nums[0] == 0) {
                count++;
            }
            if (target + nums[0] == 0) {
                count++;
            }
            return count;
        }

        if (target + offset < 0 || target + offset > 2 * offset) {
            return 0;
        }

        if (memo[n][target + offset] != null) {
            return memo[n][target + offset];
        }

        int pos = topDownHelper(nums, n - 1, target - nums[n], memo, offset);
        int neg = topDownHelper(nums, n - 1, target + nums[n], memo, offset);

        memo[n][target + offset] = pos + neg;
        return memo[n][target + offset];
    }

    // TODO: not understood yet
    // public int bottomUp(int[] nums, int target) {
    // int n = nums.length;
    // int sum = Arrays.stream(nums).sum();
    // int offset = Math.abs(sum);

    // if (Math.abs(target) > offset) {
    // return 0;
    // }

    // int[][] dp = new int[n][2 * offset + 1];
    // if (nums[0] == 0) {
    // dp[0][offset] = 2;
    // } else {
    // dp[0][offset - nums[0]] = 1;
    // dp[0][offset + nums[0]] = 1;
    // }

    // for (int i = 1; i < n; i++) {
    // for (int s = -offset; s <= offset; s++) {
    // int idx = s + offset;
    // int pos = 0, neg = 0;
    // int posIndex = s - nums[i] + offset;
    // int negIndex = s + nums[i] + offset;
    // if (posIndex >= 0 && posIndex < 2 * offset + 1) {
    // pos = dp[i - 1][posIndex];
    // }
    // if (negIndex >= 0 && negIndex < 2 * offset + 1) {
    // neg = dp[i - 1][negIndex];
    // }
    // dp[i][idx] = pos + neg;
    // }
    // }

    // return dp[n - 1][target + offset];
    // }
}

class TargetSumSolution2 {

    public int topDown(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (target > sum)
            return 0;

        // lets assume: s1 + s2 = sum, s1 - s2 = target
        // if below condition fails, that means it can't fullfill above condition
        if (target <= sum && (sum - target) % 2 == 0) {
            int s2 = (sum - target) / 2;

            int[][] memo = new int[n][s2 + 1];
            for (int[] row : memo)
                Arrays.fill(row, -1);

            return topDownHelper(nums, n - 1, s2, memo);
        } else {
            return 0;
        }

    }

    private int topDownHelper(int[] nums, int n, int target, int[][] memo) {
        if (n == 0) {
            // Base Case: we have to think like if array is of size 1 then what will happen
            // if nums[0] == traget we found a subset, return 1 (pick)
            // if nums[0] == 0 && target == 0, return 2 (pick, notPick)
            // if target == 0 && nums[0] != target, return 1, notPick we can return empty
            // subset
            if (nums[0] == target) {
                if (nums[0] == 0 && target == 0) {
                    return 2; // pick or not pick
                }
                return 1; // pick
            } else {
                if (target == 0) {
                    return 1; // not pick
                }
                return 0;
            }
        }

        if (memo[n][target] != -1) {
            return memo[n][target];
        }

        int pick = 0;
        if (nums[n] <= target) {
            pick = topDownHelper(nums, n - 1, target - nums[n], memo);
        }
        int notPick = topDownHelper(nums, n - 1, target, memo);

        memo[n][target] = pick + notPick;
        return memo[n][target];
    }

    public int bottomUp(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (target > sum) {
            return 0;
        }

        if (target <= sum && (sum - target) % 2 == 0) {
            int s2 = (sum - target) / 2;
            int t = s2;

            int[][] dp = new int[n][t + 1];

            dp[0][0] = 1;
            if (nums[0] <= t) {
                if (nums[0] == 0) {
                    dp[0][0] = 2;
                } else {
                    dp[0][nums[0]] = 1;
                }
            }

            for (int i = 1; i < n; i++) {
                for (int k = 0; k <= t; k++) {
                    int notPick = dp[i - 1][k];
                    int pick = 0;
                    if (nums[i] <= k) {
                        pick = dp[i - 1][k - nums[i]];
                    }
                    dp[i][k] = notPick + pick;
                }
            }

            return dp[n - 1][t];
        } else {
            return 0;
        }
    }
}

public class TargetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        TargetSumSolution2 sol = new TargetSumSolution2();
        System.out.println(sol.topDown(nums, target));

        sc.close();
    }
}
