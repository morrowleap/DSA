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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Permutations1 sol = new Permutations1();
        System.out.println(sol.permute2(nums));

        sc.close();
    }

    /**
     * Permutation using swapping on each index
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        int n = nums.length;

        backtrack(nums, n, 0, curr, res);

        return res;
    }

    private void backtrack(int[] nums, int n, int index, List<Integer> curr, List<List<Integer>> res) {
        if (index == n) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < n; i++) {
            swap(nums, index, i);
            curr.add(nums[index]); // We are playing on current index only, swapping it with others
            backtrack(nums, n, index + 1, curr, res); // Understand TODO: In subsequence questions we did i + 1, here we
                                                      // are doing index + 1, we are dealing with each index at a time
            curr.remove(curr.size() - 1);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Permutation using visited hash
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        int n = nums.length;
        boolean[] visited = new boolean[n];

        backtrack(nums, n, visited, curr, res);

        return res;
    }

    private void backtrack(int[] nums, int n, boolean[] visited, List<Integer> curr,
            List<List<Integer>> res) {

        if (curr.size() == n) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                curr.add(nums[i]);
                backtrack(nums, n, visited, curr, res);
                curr.remove(curr.size() - 1);
                visited[i] = false;
            }
        }
    }
}

// Recursive Time Complexity: O(n!) At first level i have N choices, the N -
// 1
// choices, .... then 1 choice

// Recursive Space Complexity: O(N)

// Overall Time Complexity: O(N! * N): Each permutaion is copied to result
