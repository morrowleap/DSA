/*
 * https://takeuforward.org/arrays/count-subarray-sum-equals-k/
 * https://youtu.be/xvNwoz-ufXA
 * 
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
*/

package arrays;

import java.util.HashMap;

public class CountSubarraysWithGivenSum {
    public static void main(String[] args) {
        // int nums[] = { 1, 1, 1 }, k = 2;
        // int nums[] = { 1, -1, 0 }, k = 0;
        int nums[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, k = 0;

        CountSubarraysWithGivenSum sol = new CountSubarraysWithGivenSum();
        System.out.println(sol.subarraySum3(nums, k));
    }

    /**
     * Optimal: Hash Map and Prefix Sum
     * T.C: O(N)
     * S.C: O(N)
     */
    public int subarraySum3(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hash = new HashMap<>();

        int count = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];

            if (sum == k) {
                count++;
            }
            if (hash.containsKey(sum - k)) { // |--- sum - k ---| + |---- k ----| = sum
                count += hash.get(sum - k);
            }

            hash.merge(sum, 1, Integer::sum);
        }

        return count;
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
