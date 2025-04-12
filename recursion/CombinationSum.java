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
        topDwon(nums, 0, target, curr, res);

        return res;
    }

    private void topDwon(int[] nums, int i, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (i == nums.length || target < 0) {
            return;
        }

        
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
