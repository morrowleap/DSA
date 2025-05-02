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

    private char[] subsets(int[] nums) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subsets'");
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
