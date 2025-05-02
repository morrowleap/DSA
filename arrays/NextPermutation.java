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

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        NextPermutation sol = new NextPermutation();

        // sol.nextPermutation(nums);
        sol.nextPermutationOptimal(nums);

        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutationOptimal(int[] nums) {
        // Observation 1: Scan the array from the end to find the first index i where
        // a[i] < a[i+1]; elements before i remain unchanged.
        int n = nums.length, i;
        for (i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        // Observation 2: In the subarray [i+1, n-1], find the smallest element greater
        // than a[i] to stay as close as possible to the current permutation.

        // Observation 3: Swap a[i] with that element, then sort (or reverse) the
        // subarray from i+1 to n-1.
        Arrays.sort(nums, i + 1, n - 1);
        for (int j = i + 1; i >= 0 && j < n; j++) {
            if (nums[j] > nums[i]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                break;
            }
        }
    }

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
