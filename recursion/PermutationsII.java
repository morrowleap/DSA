/*
 * https://leetcode.com/problems/permutations-ii/description/
 * https://youtu.be/qhBVWf0YafA
*/

package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        topDown(nums.length, count, new ArrayList<>(), res);

        res.removeAll(res);
        Arrays.sort(nums);
        topDown2(nums, 0, new ArrayList<>(), res);

        return res;
    }

    private void topDown2(int[] nums, int index, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < nums.length; i++) {

            if (i != index && nums[i] == nums[index]) {
                continue;
            }

            swap(nums, index, i);
            curr.add(nums[index]);
            topDown2(nums, index + 1, curr, res);
            curr.remove(curr.size() - 1);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void topDown(int n, Map<Integer, Integer> count, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == n) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > 0) {
                curr.add(entry.getKey());
                entry.setValue(entry.getValue() - 1);
                topDown(n, count, curr, res);
                entry.setValue(entry.getValue() + 1);
                curr.remove(curr.size() - 1);
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
