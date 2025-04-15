/*
 * https://leetcode.com/problems/permutations/description/
 * https://youtu.be/YK78FU5Ffjw
 * https://youtu.be/f2ic2Rsc9pU
 */

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutations1 {

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        topDown(nums, visited, curr, res);

        res.removeAll(res);
        topDown2(nums, 0, curr, res);

        return res;
    }

    private void topDown2(int[] nums, int index, List<Integer> curr, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < nums.length; i++) {
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

    private void topDown(int[] nums, boolean[] visited, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                curr.add(nums[i]);
                topDown(nums, visited, curr, res);
                curr.remove(curr.size() - 1);
                visited[i] = false;
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

        Permutations1 sol = new Permutations1();
        System.out.println(sol.permute(nums));

        sc.close();
    }
}

// Recursive Time Complexity: O(n!) At first level i have N choices, the N -
// 1
// choices, .... then 1 choice

// Recursive Space Complexity: O(N)

// Overall Time Complexity: O(N! * N): Each permutaion is copied to result
