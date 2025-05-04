/*
 * https://takeuforward.org/data-structure/count-the-number-of-subarrays-with-given-xor-k/
 * https://youtu.be/eZr-6p0B7ME
 * 
 * https://www.geeksforgeeks.org/count-number-subarrays-given-xor/
 * https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1
*/

package arrays;

public class CountSubarraysWithGivenXOR {
    public static void main(String[] args) {
        int arr[] = { 4, 2, 2, 6, 4 }, k = 6;

        CountSubarraysWithGivenXOR sol = new CountSubarraysWithGivenXOR();
        System.out.println(sol.subarrayXor1(arr, k));
    }

    /**
     * Recursive Approach
     * T.C: O(N^2)
     * S.C: O(N)
     */
    public long subarrayXor1(int nums[], int k) {
        return recur(nums, nums.length, 0, k);
    }

    private long recur(int[] nums, int n, int index, int k) {
        if (index == n) {
            return 0;
        }

        int xor = 0;
        long count = 0;
        for (int i = index; i < nums.length; i++) {
            xor = xor ^ nums[i];
            if (xor == k) {
                count++;
            }
        }

        return count + recur(nums, n, index + 1, k);
    }
}
