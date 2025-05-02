/*
 * https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/
 * https://youtu.be/JDOXKqF60RQ
 * 
 * https://leetcode.com/problems/next-permutation/description/
*/

package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NextPermutation {

    /**
     * Brute-Force Approach: Taking out all permutations and then checking the next
     * permutation
     */
    public void nextPermutation(int[] nums) {
        List<Integer> og = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            og.add(nums[i]);
        }
        List<List<Integer>> perm = collectAllPermutations(nums);

        for (int i = 0; i < perm.size(); i++) {
            if (perm.get(i).equals(og)) {
                List<Integer> candidate;
                if (i + 1 == perm.size()) {
                    candidate = perm.get(0);
                } else {
                    candidate = perm.get(i + 1);
                }
                for (int j = 0; j < nums.length; j++)
                    nums[j] = candidate.get(j);
            }
        }
    }

    /**
     * Returns all permutations for a collection of numbers, duplicates allowed
     */
    private List<List<Integer>> collectAllPermutations(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Map<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        backtrack(nums, hash, curr, res);

        return res;
    }

    private void backtrack(int[] nums, Map<Integer, Integer> hash, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (count > 0) {
                curr.add(num);
                hash.put(num, count - 1);
                backtrack(nums, hash, curr, res);
                curr.remove(curr.size() - 1);
                hash.put(num, count);
            }
        }
    }
}
