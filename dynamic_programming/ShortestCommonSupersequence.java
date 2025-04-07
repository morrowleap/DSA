/*
 * https://takeuforward.org/data-structure/shortest-common-supersequence-dp-31/
 * https://leetcode.com/problems/shortest-common-supersequence/
*/

package dynamic_programming;

import java.util.Scanner;

class ShortestCommonSupersequenceSol {
    private int[][] bottomUp(String text1, String text2) {
        // LongestCommonSubSequence.java bottomUp approach
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1)
                        ? 1 + dp[i - 1][j - 1]
                        : Math.max(dp[i - 1][j], dp[i][j - 1]);
        return dp;
    }

    public String shortestCommonSupersequence(String text1, String text2) {
        int[][] dp = bottomUp(text1, text2);
        int m = dp.length - 1;
        int n = dp[0].length - 1;

        StringBuilder res = new StringBuilder();

        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                res.append(text1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    res.append(text1.charAt(i - 1));
                    i--;
                } else {
                    res.append(text2.charAt(j - 1));
                    j--;
                }
            }
        }
        while (i > 0) {
            res.append(text1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            res.append(text2.charAt(j - 1));
            j--;
        }

        return res.reverse().toString();
    }
}

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text1 = sc.nextLine();
        String text2 = sc.nextLine();

        ShortestCommonSupersequenceSol sol = new ShortestCommonSupersequenceSol();
        System.out.println(sol.shortestCommonSupersequence(text1, text2));

        sc.close();
    }
}
