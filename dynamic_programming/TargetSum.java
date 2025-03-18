/*
 * https://takeuforward.org/data-structure/target-sum-dp-21/
 * https://leetcode.com/problems/target-sum/
*/

package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

class TargetSumSolution1 {

    public int topDown(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int offset = Math.abs(sum);

        if (Math.abs(target) > offset)
            return 0;

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

        TargetSumSolution1 sol = new TargetSumSolution1();
        System.out.println(sol.topDown(nums, target));

        sc.close();
    }
}
