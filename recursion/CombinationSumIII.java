/*
 * https://leetcode.com/problems/combination-sum-iii/description/
*/

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSumIII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();

        CombinationSumIII sol = new CombinationSumIII();
        System.out.println(sol.combinationSum3(k, n));

        sc.close();
    }

    public List<List<Integer>> combinationSum3(int count, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        // backtrack(1, count, target, curr, res);
        backtrack2(1, count, target, curr, res);

        return res;
    }

    /**
     * For-Loop making subsequences technique
     */
    public void backtrack2(int index, int count, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0 && count == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0 || count < 0 || index > 9) {
            return;
        }

        for (int i = index; i <= 9; i++) {
            curr.add(i);
            backtrack2(i + 1, count - 1, target - i, curr, res);
            curr.remove(curr.size() - 1);
        }

        // TODO: Attach recursion tree
    }

    /**
     * Pick and non pick technique
     */
    public void backtrack(int index, int count, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0 && count == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0 || count < 0 || index > 9) {
            return;
        }

        curr.add(index);
        backtrack(index + 1, count - 1, target - index, curr, res);
        curr.remove(curr.size() - 1);

        backtrack(index + 1, count, target, curr, res);

        // TODO: Attach recursion tree
    }
}

// Recursive Time Complexity: O(2^N)
// Recursive Space Complexity: O(N)

// Overall Time Complexity: O(2^N * N)
// Overall Space Complexity: O(N + 2^N * N)
