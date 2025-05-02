/*
 * https://takeuforward.org/data-structure/power-set-print-all-the-possible-subsequences-of-the-string/
 * https://youtu.be/b7AYbpM5YrE
 * 
 * https://leetcode.com/problems/subsets/description/
 * 
 * Print all subsequences
 * Power Set: Print all the possible subsequences of the String
 * 78. Subsets
*/

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintAllSubsequences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        PrintAllSubsequences sol = new PrintAllSubsequences();
        System.out.println(sol.subsets(nums));

        sc.close();
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, nums.length - 1, curr, res);

        backtrack2(nums, 0, curr, res);

        return res;
    }

    private void backtrack(int[] nums, int n, List<Integer> curr, List<List<Integer>> res) {
        if (n == -1) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[n]);
        backtrack(nums, n - 1, curr, res);
        curr.remove(curr.size() - 1);

        backtrack(nums, n - 1, curr, res);

        // TODO: Attach recursion tree
    }

    private void backtrack2(int[] nums, int index, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack2(nums, i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }

        // TODO: Attach recursion tree
    }
}

// Recursive Time Complexity: At each step we have 2 coices either to choose or
// not to choose, O(2^N)
// Recursive Space Complexity: Stack space goes till O(N)

// Overall Time Complexity: O(N * 2^N): Since in base case we create a copy of
// each subset,
// that creates a O(N) time complexity so for each subset O(N * 2^N) time
// complexity

// Overall Space complexity: O(N * 2^N + N), Since we store 2^N string of length
// N and a
// recursion stackspace of length N
