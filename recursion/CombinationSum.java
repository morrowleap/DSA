/*
 * https://takeuforward.org/data-structure/combination-sum-1/
 * https://youtu.be/OyZFFqQtu98
 * 
 * https://leetcode.com/problems/combination-sum/description/
*/

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        CombinationSum sol = new CombinationSum();
        System.out.println(sol.combinationSum(nums, target));

        sc.close();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        backtrack(candidates, candidates.length - 1, target, curr, res);

        backtrack2(candidates, 0, target, curr, res);

        return res;
    }

    /**
     * Using pick and non pick technique
     */
    private void backtrack(int[] nums, int n, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0 || n < 0)
            return;

        curr.add(nums[n]);
        backtrack(nums, n, target - nums[n], curr, res);
        curr.remove(curr.size() - 1);

        backtrack(nums, n - 1, target, curr, res);

        // TODO: Attach recursion tree
    }

    /**
     * Using looping through choices.
     * Generate all combinations (with repetition) of nums[index…] that sum to
     * target.
     */
    private void backtrack2(int[] nums, int index, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0 || index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack2(nums, i, target - nums[i], curr, res);
            curr.remove(curr.size() - 1);
        }

        // TODO: Attach recursion tree
    }
}

// Recursive Time Complexity: Much more than O(2^N) , beacuse at each step we
// have the choice of picking the current element again and again
// pick or not pick

// Recursive Space Complexity: O(N)

// Overall Space Complexity: O(N * 2^N + N), more than that
