/*
 * https://takeuforward.org/data-structure/minimum-insertions-deletions-to-convert-string-dp-30/
 * https://leetcode.com/problems/delete-operation-for-two-strings/
*/

package dynamic_programming;

import java.util.Scanner;

class MinimumInsertionsDeletionstoConvertStringSol {
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

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int lcs = bottomUp(word1, word2);
        return m - lcs + n - lcs;
    }
}

public class MinimumInsertionsDeletionstoConvertString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text1 = sc.nextLine();
        String text2 = sc.nextLine();

        MinimumInsertionsDeletionstoConvertStringSol sol = new MinimumInsertionsDeletionstoConvertStringSol();
        System.out.println(sol.minDistance(text1, text2));

        sc.close();
    }
}
