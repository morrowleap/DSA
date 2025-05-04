/*
 * https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/
 * https://youtu.be/2D0D8HE6uak
 * 
 * https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
*/

package arrays;

import java.util.ArrayList;

public class FindRepeatingAndMissingNumber {
    public static void main(String[] args) {
        int nums[] = { 2, 2 };

        FindRepeatingAndMissingNumber sol = new FindRepeatingAndMissingNumber();
        System.out.println(sol.findTwoElement1(nums));
    }

    /**
     * Bit manipulation method: TODO: https://youtu.be/2D0D8HE6uak?t=1189
     * 
     */
    public ArrayList<Integer> findTwoElement4(int[] nums) {
        return null;
    }

    /**
     * Maths
     * T.C: O(N)
     * S.C: O(1)
     */
    public ArrayList<Integer> findTwoElement3(int nums[]) {
        int n = nums.length;

        // Let's x be the repeating number, y be the missing number
        // Original array - [1..n] array = x - y
        // ex: nums = [1,2,2]
        // [1,2,2] - [1,2,3] = 2 - 3

        long xminusy = 0;
        for (int i = 1; i <= n; i++) {
            xminusy += nums[i - 1] - i;
        }

        // Similarly for (Original array)^2 - ([1..n] array)^2 = x^2 - y^2
        long x2minusy2 = 0;
        for (int i = 1; i <= n; i++) {
            x2minusy2 += Math.pow(nums[i - 1], 2) - Math.pow(i, 2);
        }

        // x^2 - y^2 / x - y = x + y
        long xplusy = x2minusy2 / xminusy;

        ArrayList<Integer> res = new ArrayList<>();
        res.add((int) (xplusy + xminusy) / 2);
        res.add((int) (xplusy - xminusy) / 2);
        return res;
    }

    /**
     * Brute-Force: Recursive code converted to iterative
     * T.C: O(N)
     * S.C: O(1)
     */
    public ArrayList<Integer> findTwoElement2(int nums[]) {
        int N = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(0);
        for (int x = 1; x <= N; x++) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (nums[i] == x) {
                    count++;
                }
            }

            if (count == 2) { // Repeating number
                res.set(0, x);
            }
            if (count == 0) { // Missing number
                res.set(1, x);
            }
        }
        return res;
    }

    /**
     * Recursive Approach
     * T.C: O(N^2)
     * S.C: O(N)
     */
    public ArrayList<Integer> findTwoElement1(int nums[]) {
        int N = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(0);
        recur(N, 1, nums, res);
        return res;
    }

    private void recur(int N, int x, int[] nums, ArrayList<Integer> res) {
        if (x > N) {
            return;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                count++;
            }
        }

        if (count == 2) { // Repeating number
            res.set(0, x);
        }
        if (count == 0) { // Missing number
            res.set(1, x);
        }

        recur(N, x + 1, nums, res);
    }
}
