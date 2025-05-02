/*
 * https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero/
 * https://youtu.be/DhFh8Kw7ymk
 * 
 * https://leetcode.com/problems/3sum/description/
*/

package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int nums[] = { -1, 0, 1, 2, -1, -4 };

        ThreeSum sol = new ThreeSum();
        System.out.println(sol.threeSumRecursive(nums));
    }

    public List<List<Integer>> threeSumRecursive(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(nums);
        backtrack(nums, 3, 0, 0, curr, res);
        return res;
    }

    private void backtrack(int[] nums, int count, int target, int index, List<Integer> curr, List<List<Integer>> res) {
        if (count == 0 && target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (count < 0 || index == nums.length) {
            return;
        }

        curr.add(nums[index]);
        backtrack(nums, count - 1, target - nums[index], index + 1, curr, res);
        curr.remove(curr.size() - 1);

        while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
            index++;
        }
        backtrack(nums, count, target, index + 1, curr, res);
    }
}
