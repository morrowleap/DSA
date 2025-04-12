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
        topDown(nums, i, target - nums[i], curr, res);
        curr.remove(curr.size() - 1);

        topDown(nums, i + 1, target, curr, res);
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

// Recursive Time Complexity: O(2^N) on each step 2 choices are there either
// pick or not pick

// Recursive Space Complexity: O(N)

// Overall Space Complexity: O(N * 2^N + N)
