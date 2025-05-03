/*
 * https://takeuforward.org/data-structure/subset-ii-print-all-the-unique-subsets/
 * https://youtu.be/RIn3gOkbhQE
 * 
 * https://leetcode.com/problems/subsets-ii/description/
*/

package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubsetII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        SubsetII sol = new SubsetII();
        System.out.println(sol.subsetsWithDup(nums));

        sc.close();
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(nums);
        // backtrack(nums, 0, curr, res);
        backtrack2(nums, 0, curr, res);

        return res;
    }

    /**
     * For-Loop making subsequences technique
     */
    public void backtrack2(int[] nums, int index, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack2(nums, i + 1, curr, res);
            curr.remove(curr.size() - 1);

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        // TODO: Attach recursion tree
    }

    /**
     * Pick and non pick technique
     */
    public void backtrack(int[] nums, int index, List<Integer> curr, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        backtrack(nums, index + 1, curr, res);
        curr.remove(curr.size() - 1);

        while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
            index++; // Skipping duplicates, same as Combination Sum 2
        }
        backtrack(nums, index + 1, curr, res);

        // TODO: Attach recursion tree
    }
}

// Recursive Time Complexity: O(2^N)
// Recursive Space Complexity: O(N)

// Overall Time Complexity: O(2^N * N)
// Overall Space Complexity: O(N + 2^N * N)
