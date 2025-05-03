/*
 * https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/
 * https://youtu.be/AHZpyENo7k4
 * 
 * https://leetcode.com/problems/maximum-subarray/description/
*/

package arrays;

public class MaxSubarraySumKadanesAlgo {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        MaxSubarraySumKadanesAlgo sol = new MaxSubarraySumKadanesAlgo();
        System.out.println(sol.maxSubArrayBrute(nums));
    }

    /**
     * Brute-Force: Recursive code converted to brute force
     * T.C: O(N^2)
     * S.C: O(1)
     */
    public int maxSubArrayBrute(int[] nums) {
        int n = nums.length;
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                maxsum = Math.max(maxsum, sum);
            }
        }
        return maxsum;
    }

    /**
     * Recursive Approach
     * T.C: O(N^2)
     * S.C: O(N)
     */
    public int maxSubArrayRecursive(int[] nums) {
        int maxsum = Integer.MIN_VALUE;
        return recur(nums, 0, maxsum);
    }

    private int recur(int[] nums, int index, int maxsum) {
        if (index == nums.length) {
            return maxsum;
        }

        int sum = 0;
        for (int i = index; i < nums.length; i++) {
            sum += nums[i];
            maxsum = Math.max(maxsum, sum);
        }

        return recur(nums, index + 1, maxsum);
    }
}
