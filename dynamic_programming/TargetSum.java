/*
 * https://takeuforward.org/data-structure/target-sum-dp-21/
 * https://leetcode.com/problems/target-sum/
*/

package dynamic_programming;

import java.util.Scanner;

class TargetSumSolution1 {

    public int topDown(int[] nums, int target) {
        int n = nums.length;
        return topDownHelper(nums, n - 1, target);
    }

    private int topDownHelper(int[] nums, int n, int target) {
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
        
        int pos = topDownHelper(nums, n - 1, target + nums[n]);
        int neg = topDownHelper(nums, n - 1, target - nums[n]);

        return pos + neg;
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
