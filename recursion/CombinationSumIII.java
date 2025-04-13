/*
 * https://leetcode.com/problems/combination-sum-iii/description/
*/

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        topDown(1, k, n, curr, res);
        topDown2(1, k, n, curr, res);
        return res;
    }

    /**
     * For-Loop making subsequences technique
     */
    private void topDown2(int index, int count, int target, List<Integer> curr, List<List<Integer>> res) {
        if (count == 0) {
            if (target == 0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        for (int i = index; i <= 9; i++) {
            curr.add(i);
            topDown2(i + 1, count - 1, target - i, curr, res);
            curr.remove(curr.size() - 1);
        }

        // TODO: Attach recursion tree
    }

    /**
     * Pick and non pick technique
     */
    private void topDown(int i, int count, int target, List<Integer> curr, List<List<Integer>> res) {
        if (count == 0) {
            if (target == 0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        if (i == 10) {
            return;
        }

        curr.add(i);
        topDown(i + 1, count - 1, target - i, curr, res);
        curr.remove(curr.size() - 1);

        topDown(i + 1, count, target, curr, res);

        // TODO: Attach recursion tree
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();

        CombinationSumIII sol = new CombinationSumIII();
        System.out.println(sol.combinationSum3(k, n));

        sc.close();
    }
}

// Recursive Time Complexity: O(2^N)
// Recursive Space Complexity: O(N)

// Overall Time Complexity: O(2^N * N)
// Overall Space Complexity: O(N + 2^N * N)
