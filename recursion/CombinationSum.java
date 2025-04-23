/*
 * https://takeuforward.org/data-structure/combination-sum-1/
 * https://leetcode.com/problems/combination-sum/description/
 * https://youtu.be/OyZFFqQtu98
*/

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        topDown(nums, 0, target, curr, res);
        topDown2(nums, target, target, curr, res);

        return res;
    }

    /**
     * Using pick and non pick technique
     */
    private void topDown(int[] nums, int i, int target, List<Integer> curr, List<List<Integer>> res) {
        if (i == nums.length || target < 0) {
            if (target == 0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        curr.add(nums[i]);
        topDown(nums, i, target - nums[i], curr, res);
        curr.remove(curr.size() - 1);

        topDown(nums, i + 1, target, curr, res);

        // TODO: Attach recursion tree
    }

    /**
     * Using looping through choices.
     * Generate all combinations (with repetition) of nums[index…] that sum to
     * target.
     */
    private void topDown2(int[] nums, int index, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (index == nums.length || target < 0) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            topDown(nums, i, target - nums[i], curr, res);
            curr.remove(curr.size() - 1);
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

        CombinationSum sol = new CombinationSum();
        System.out.println(sol.combinationSum(nums, target));

        sc.close();
    }
}

// Recursive Time Complexity: Much more than O(2^N) , beacuse at each step we
// have the choice of picking the current element again and again
// pick or not pick

// Recursive Space Complexity: O(N)

// Overall Space Complexity: O(N * 2^N + N), more than that
