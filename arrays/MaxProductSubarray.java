/*
 * https://takeuforward.org/data-structure/maximum-product-subarray-in-an-array/
 * https://youtu.be/hnswaLJvr6g
 * 
 * https://leetcode.com/problems/maximum-product-subarray/description/
*/

package arrays;

public class MaxProductSubarray {
    public static void main(String[] args) {
        int nums[] = { 2, 3, -2, 4 };

        MaxProductSubarray sol = new MaxProductSubarray();
        System.out.println(sol.maxProduct3(nums));
    }

    /**
     * 
    */
    public int maxProduct3(int[] nums) {

        throw new UnsupportedOperationException("Unimplemented method 'maxProduct3'");
    }

    /**
     * Iterative Approach
     * T.C: O(N^2)
     * S.C: O(1)
     */
    public int maxProduct2(int[] nums) {
        int n = nums.length;
        int product = 1, maxP = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            product = 1;
            for (int j = i; j < n; j++) {
                product = product * nums[j];
                maxP = Math.max(maxP, product);
            }
        }
        return maxP;
    }

    /**
     * Recursive Approach
     * T.C: O(N^2)
     * S.C: O(N)
     */
    public int maxProduct1(int[] nums) {
        int n = nums.length;
        return recur(n, 0, nums);
    }

    private int recur(int n, int index, int[] nums) {
        if (index == n) {
            return Integer.MIN_VALUE;
        }

        int product = 1, maxP = Integer.MIN_VALUE;
        for (int i = index; i < n; i++) {
            product = product * nums[i];
            maxP = Math.max(maxP, product);
        }

        return Math.max(maxP, recur(n, index + 1, nums));
    }
}
