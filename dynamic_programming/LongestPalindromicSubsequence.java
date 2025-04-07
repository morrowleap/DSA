/*
 * https://takeuforward.org/data-structure/longest-palindromic-subsequence-dp-28/
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
*/

package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

class LongestPalindromicSubsequenceSol {
    public int longestPalindromeSubseq(String text) {
        String text2 = new StringBuilder(text).reverse().toString();
        return bottomUp(text, text2);
    }

    @SuppressWarnings("unused")
    private int topDown(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return topDownHelper(text1, m, text2, n, memo);
    }

    private int topDownHelper(String text1, int m, String text2, int n, int[][] memo) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            memo[m][n] = 1 + topDownHelper(text1, m - 1, text2, n - 1, memo);
        } else {
            int check1 = topDownHelper(text1, m - 1, text2, n, memo);
            int check2 = topDownHelper(text1, m, text2, n - 1, memo);

            memo[m][n] = Math.max(check1, check2);
        }

        return memo[m][n];
    }

    private int bottomUp(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int check1 = dp[i - 1][j];
                    int check2 = dp[i][j - 1];

                    dp[i][j] = Math.max(check1, check2);
                }
            }
        }

        return dp[m][n];
    }
}

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        LongestPalindromicSubsequenceSol sol = new LongestPalindromicSubsequenceSol();

        System.out.println(sol.longestPalindromeSubseq(text));

        sc.close();
    }
}
