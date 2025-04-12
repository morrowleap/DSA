/*
 * L7. All Kind of Patterns in Recursion | Print All | Print one | Count
 * https://youtu.be/eQCS_v3bw0Q
*/

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsequenceWhoseSumIsK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        SubsequenceWhoseSumIsK sol = new SubsequenceWhoseSumIsK();
        System.out.println(sol.printSubSeq(nums, 0, target, new ArrayList<>(), new ArrayList<>()));
        System.out.println(sol.checkSubSeq(nums, 0, target));
        System.out.println(sol.countSubSeq(nums, 0, target));

        sc.close();
    }

    private int countSubSeq(int[] nums, int i, int target) {
        if (i == nums.length) {
            if (target == 0)
                return 1;
            else
                return 0;
        }
        return countSubSeq(nums, i + 1, target - nums[i]) + countSubSeq(nums, i + 1, target);
    }

    private boolean checkSubSeq(int[] nums, int i, int target) {
        if (i == nums.length) {
            if (target == 0)
                return true;
            else
                return false;
        }
        return checkSubSeq(nums, i + 1, target - nums[i]) || checkSubSeq(nums, i + 1, target);
    }

    private List<List<Integer>> printSubSeq(int[] nums, int i, int target, List<Integer> curr,
            List<List<Integer>> res) {
        if (i == nums.length) {
            if (target == 0) {
                res.add(new ArrayList<>(curr));
            }
            return res;
        }

        curr.add(nums[i]);
        printSubSeq(nums, i + 1, target - nums[i], curr, res);
        curr.remove(curr.size() - 1);

        printSubSeq(nums, i + 1, target, curr, res);

        return res;
    }
}

// Recursive Time Complexity: O(2^N) on each step 2 choices are there either
// pick or not pick

// Recursive Space Complexity: O(N)

// Overall Space Complexity: O(N * 2^N + N)
