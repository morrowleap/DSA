/*
 * https://takeuforward.org/data-structure/minimum-insertions-to-make-string-palindrome-dp-29/
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
*/

package dynamic_programming;

import java.util.Scanner;

class MinimumInsertionStepstoMakeaStringPalindromeSol {
    private int bottomUp(String text1, String text2) {
        // LongestCommonSubSequence.java bottomUp approach
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1)
                        ? 1 + dp[i - 1][j - 1]
                        : Math.max(dp[i - 1][j], dp[i][j - 1]);
        return dp[m][n];
    }

    public int minInsertions(String s) {
        int n = s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        return n - bottomUp(s, s2);
    }
}

public class MinimumInsertionStepstoMakeaStringPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        MinimumInsertionStepstoMakeaStringPalindromeSol sol = new MinimumInsertionStepstoMakeaStringPalindromeSol();
        System.out.println(sol.minInsertions(text));

        sc.close();
    }
}
