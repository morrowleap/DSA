/*
 * https://takeuforward.org/data-structure/combination-sum-ii-find-all-unique-combinations/
 * https://youtu.be/G1fRTGRxXU8
 * https://leetcode.com/problems/combination-sum-ii/description/
*/

package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        topDown(candidates, 0, target, curr, res);
        topDown2(candidates, 0, target, curr, res);

        return res;
    }

    private void topDown(int[] nums, int i, int target, List<Integer> curr, List<List<Integer>> res) {
        if (i == nums.length || target < 0) {
            if (target == 0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        curr.add(nums[i]);
        topDown(nums, i + 1, target - nums[i], curr, res);
        curr.remove(curr.size() - 1);

        // After choosing above one, element is filled at 0th index of this subset, now
        // in case of
        // non pick it will go further in recursion, where in next recursion it will
        // pick element for 0th index of another subset, so if the next element which we
        // are shifting to
        // for choices of picking it or not picking it, if that element is equal to our
        // current element which we have already used in a subset at 0th index, we will
        // ignore that for another subsets at 0th index
        while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
            i++; // skipping duplicate elements
        }
        topDown(nums, i + 1, target, curr, res);

        // Why index is not incremented in the "pick" part ? because it would miss valid
        // combinations because the next recursive depth would skip the immediate next
        // candidate unnecessarily.

        // TODO: Attach recursion tree
    }

    private void topDown2(int[] nums, int index, int target, List<Integer> curr, List<List<Integer>> res) {
        // TODO: understand and write down what is happening
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (index == nums.length || target < 0) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            topDown2(nums, i, target - nums[i], curr, res);
            curr.remove(curr.size() - 1);

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++; // skipping duplicate elements
            } // This loop shifts pinter to last similar element, then for loop shifts pointer
              // to next element
        }

        // TODO: Attach recursion tree
    }

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
}

// Recursive Time Complexity: O(2^N)
// Recursive Space Complexity: O(N)

// Overall Time Complexity: O(2^N + NlogN)
// Overall Space Complexity: O(N * 2^N + N)
