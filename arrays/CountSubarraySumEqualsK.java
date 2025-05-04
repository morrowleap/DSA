/*
 * https://takeuforward.org/arrays/count-subarray-sum-equals-k/
 * https://youtu.be/xvNwoz-ufXA
 * 
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
*/

package arrays;

public class CountSubarraySumEqualsK {
    public static void main(String[] args) {
        int nums[] = { 1, 1, 1 }, k = 2;

        CountSubarraySumEqualsK sol = new CountSubarraySumEqualsK();
        System.out.println(sol.subarraySum2(nums, k));
    }

    /**
     * Brute-Force: Recursive code converted to iterative
     * T.C: O(N^2)
     * S.C: O(1)
     */
    public int subarraySum2(int[] nums, int k) {
        int n = nums.length, count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Recursive Approach
     * T.C: O(N^2)
     * S.C: O(N)
     */
    public int subarraySum1(int[] nums, int k) {
        return recur(nums, nums.length, 0, k);
    }

    private int recur(int[] nums, int n, int index, int k) {
        if (index == n) {
            return 0;
        }

        int sum = 0, count = 0;
        for (int i = index; i < n; i++) {
            sum = sum + nums[i];
            if (sum == k) {
                count++;
            }
        }

        return count + recur(nums, n, index + 1, k);
    }
}
