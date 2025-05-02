/*
 * https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-sum-exists-in-array/
 * https://youtu.be/UXDSeD9mN-k
 * 
 * https://leetcode.com/problems/two-sum/description/
*/

package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Brute-Force Approach
     */
    public int[] twoSumBrute(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == target - nums[j]) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hash = new HashMap<>(); // Store curr, index
        for (int i = 0; i < n; i++) {
            if (hash.containsKey(nums[i])) {
                return new int[] { i, hash.get(nums[i]) };
            }
            hash.put(target - nums[i], i);
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int nums[] = { 2, 7, 11, 15 }, target = 9;

        TwoSum sol = new TwoSum();
        int res[] = sol.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
