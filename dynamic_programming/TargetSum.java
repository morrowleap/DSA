/*
 * https://takeuforward.org/data-structure/target-sum-dp-21/
 * https://leetcode.com/problems/target-sum/
*/

package dynamic_programming;

import java.util.Scanner;

class TargetSumSolution {

    public int topDown(int[] nums, int target) {
        int n = nums.length;
        int offset = Math.abs(target);
        Integer[][] memo = new Integer[n][2 * offset + 1];
        return topDownHelper(nums, n - 1, target, memo, offset);
    }

    private int topDownHelper(int[] nums, int n, int target, Integer[][] memo, int offset) {
        if (n == 0) {
            if (nums[0] == Math.abs(target)) {
                if (nums[0] == 0) {
                    return 2;
                } else {
                    return 1;
                }
            } else {
                return 0;
            }
        }

        if (memo[n][target + offset] != null) 
            return memo[n][target + offset];
        
        int pos = topDownHelper(nums, n - 1, target + nums[n], memo, offset);
        int neg = topDownHelper(nums, n - 1, target - nums[n], memo, offset);

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

        TargetSumSolution sol = new TargetSumSolution();
        System.out.println(sol.topDown(nums, target));

        sc.close();
    }
}
