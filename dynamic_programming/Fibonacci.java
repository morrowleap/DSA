package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

class Solution {
    static final int MOD = 1_000_000_007;

    static int topDown(int n, int[] memo) {
        if (n < 2) return n;
        if (memo[n] != -1) return memo[n];
        memo[n] = (topDown(n - 1, memo) + topDown(n - 2, memo)) % MOD;
        return memo[n];
    }

    static long topDown(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return topDown(n, memo);
    }

    static long bottomUp(int n) {
        if (n < 2) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = (a + b) % MOD;
            a = b;
            b = temp;
        }
        return b;
    }
}

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(ProblemDescription.getText());

        System.out.print("Enter the index: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(n + "th index fibonacci number from top down approach: " + Solution.topDown(n));
        System.out.println(n + "th index fibonacci number from bottom up approach: " + Solution.bottomUp(n));

        sc.close();
    }
}

class ProblemDescription {
    public static String getText() {
        return """
https://www.geeksforgeeks.org/problems/introduction-to-dp/1
Introduction to DP

Geek is learning data structures, and he recently learned about the top-down and
bottom-up dynamic programming approaches. Geek is having trouble telling them
apart from one another.

When given an integer n, where n is based on a 0-based index, find the nth
Fibonacci number.

Every ith number in the series equals the sum of the (i-1)th and (i-2)th
numbers, where the first and second numbers are specified as 0 and 1,
respectively.

For the given issue, code both top-down and bottom-up approaches.

Note : As the answer might be large, return the final answer modulo 109 + 7

Example 1:

Input:
n = 5
Output: 5
Explanation: 0,1,1,2,3,5 as we can see 5th number is 5.
Example 2:

Input:
n = 6
Output: 8
Explanation: 0,1,1,2,3,5,8 as we can see 6th number is 8.
Constraints:
1 <= n <= 10^4

Your Task:
You don't need to read input or print anything. Your task is to complete two
functions topDown() and bottomUp() which take n as input parameters and return
the nth Fibonacci number.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)
        """;
    }
}
