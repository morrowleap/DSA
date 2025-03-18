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
        Integer[][] memo = new Integer[n][2 * offset + 1];
        return topDownHelper(nums, n - 1, 0, target, memo, offset);
    }

    private int topDownHelper(int[] nums, int n, int sum, int target, Integer[][] memo, int offset) {
        if (n == 0) {
            if (nums[0] == Math.abs(target - sum)) {
                if (nums[0] == 0) {
                    return 2;
                } else {
                    return 1;
                }
            } else {
                return 0;
            }
        }
        
        if (memo[n][sum + offset] != null) 
            return memo[n][sum + offset];
        
        int pos = topDownHelper(nums, n - 1, sum + nums[n], target, memo, offset);
        int neg = topDownHelper(nums, n - 1, sum - nums[n], target, memo, offset);

        memo[n][sum + offset] = pos + neg;
        return memo[n][sum + offset];
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
