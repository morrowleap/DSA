/*
 * https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero/
 * https://youtu.be/DhFh8Kw7ymk
 * 
 * https://leetcode.com/problems/3sum/description/
*/

package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        int nums[] = { -1, 0, 1, 2, -1, -4 };

        ThreeSum sol = new ThreeSum();
        System.out.println(sol.threeSum2Pointer(nums));
    }

    /**
     * Optimal Approach 2 pointers
     * T.C: O(NlogN) + O(N^2)
     * S.C: O(K), K = no. of unique triplets
     */
    public List<List<Integer>> threeSum2Pointer(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int x = nums[i] + nums[j] + nums[k];
                if (x == 0) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j - 1] == nums[j]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (x < 0) {
                    j++;
                } else {
                    k--;
                }
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    /**
     * Hash Optimized Approach
     * T.C: O(NlogN) + O(N^2)
     * S.C: O(N)map + O(K)set + O(K)list = O(N) + O(K*2), K = no. of unique triplets
     */
    public List<List<Integer>> threeSumHashing(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> hash = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int numsk = -(nums[i] + nums[j]);
                if (hash.containsKey(numsk)) {
                    res.add(List.of(nums[i], nums[j], numsk));
                }
                hash.put(nums[j], j);
            }
        }
        return new ArrayList<>(res);
    }

    /**
     * Brute-Force method
     * T.C: O(NlogN) + O(N^3)
     * S.C: O(K), K = no. of unique triplets
     */
    public List<List<Integer>> threeSumBrute(int[] nums) {
        Arrays.sort(nums); // ensures triplets are in non-decreasing order for deduplication
        HashSet<List<Integer>> res = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(List.of(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    /**
     * 3 sum problem using backtracking
     * T.C: O(NlogN) + O(C(N,3)) = O(NlogN) + O(N!/((N-3)! * 3!)) = O(N^3)
     * S.C: O(3) = O(1)
     */
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
