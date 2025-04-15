/*
 * https://leetcode.com/problems/permutations-ii/description/
 * https://youtu.be/qhBVWf0YafA
*/

package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer> perm = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        topDown(nums.length, count, perm, res);

        return res;
    }

    private void topDown(int n, Map<Integer, Integer> count, List<Integer> perm, List<List<Integer>> res) {
        if (perm.size() == n) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > 0) {
                perm.add(entry.getKey());
                entry.setValue(entry.getValue() - 1);
                topDown(n, count, perm, res);
                entry.setValue(entry.getValue() + 1);
                perm.remove(perm.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        PermutationsII sol = new PermutationsII();
        System.out.println(sol.permuteUnique(nums));

        sc.close();
    }
}
