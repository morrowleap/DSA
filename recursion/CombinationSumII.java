/*
 * https://takeuforward.org/data-structure/combination-sum-ii-find-all-unique-combinations/
 * https://youtu.be/G1fRTGRxXU8
 * 
 * https://leetcode.com/problems/combination-sum-ii/description/
*/

package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSumII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        CombinationSumII sol = new CombinationSumII();
        System.out.println(sol.combinationSum2(nums, target));

        sc.close();

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(candidates);

        // backtrack(candidates, 0, target, curr, res);
        backtrack2(candidates, 0, target, curr, res);

        return res;
    }

    public void backtrack2(int[] nums, int index, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (index == nums.length || target < 0) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack2(nums, i + 1, target - nums[i], curr, res);
            curr.remove(curr.size() - 1);

            // In this approach we are generating subsets for a specific index, lets say we
            // put value 1 at 0th index in a subset, now in other subset doing the same
            // would not be good so with the below while loop we skip the duplicate element
            // at
            // same index for any other subset
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++; // skipping duplicate elements
            } // This loop shifts pinter to last similar element, then for loop shifts pointer
              // to next element
        }

        // TODO: Attach recursion tree
    }

    public void backtrack(int[] nums, int index, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0 || index == nums.length) {
            return;
        }

        curr.add(nums[index]);
        backtrack(nums, index + 1, target - nums[index], curr, res);
        curr.remove(curr.size() - 1);

        // After choosing above one, element is filled at 0th index of this subset, now
        // in case of
        // non pick it will go further in recursion, where in next recursion it will
        // pick element for 0th index of another subset, so if the next element which we
        // are shifting to
        // for choices of picking it or not picking it, if that element is equal to our
        // current element which we have already used in a subset at 0th index, we will
        // ignore that for another subsets at 0th index
        while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
            index++; // skipping duplicate elements
        }
        backtrack(nums, index + 1, target, curr, res);

        // Why index is not incremented in the "pick" part ? because it would miss valid
        // combinations because the next recursive depth would skip the immediate next
        // candidate unnecessarily.

        // TODO: Attach recursion tree
    }

}

// Recursive Time Complexity: O(2^N)
// Recursive Space Complexity: O(N)

// Overall Time Complexity: O(2^N + NlogN)
// Overall Space Complexity: O(N * 2^N + N)
