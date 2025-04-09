/*
 * https://takeuforward.org/data-structure/distinct-subsequences-dp-32/
 * https://leetcode.com/problems/distinct-subsequences/description/
*/

package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

class DistinctSubsequencesSol {
    public int numDistinct(String s, String t) {
        return topDown(s, t);
    }

    public int topDown(String s, String t) {
        int m = t.length();
        int n = s.length();

        int[][] memo = new int[m + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return topDownHelper(t, m, s, n, memo);
    }

    private int topDownHelper(String t, int m, String s, int n, int[][] memo) {
        if (m == 0) {
            return 1;
        } else if (n == 0) {
            return 0;
        }

        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        if (s.charAt(n - 1) == t.charAt(m - 1)) {
            // If they are matching we can reduce the pointers on both and start finding for
            // next elements
            // For another occurence of the same character we can choose to not pick current
            // in s and move on further in s to find next occurence of t[m]
            memo[m][n] = topDownHelper(t, m - 1, s, n - 1, memo) + topDownHelper(t, m, s, n - 1, memo);
        } else {
            // In the case they not match so we can't do anything for s[n] anyway so we move
            // forward in s further to find a "subsequence of s" = t
            memo[m][n] = topDownHelper(t, m, s, n - 1, memo);
        }

        return memo[m][n];
    }

    public int bottomUp(String s, String t) {
        int m = t.length();
        int n = s.length();

        int[][] dp = new int[m + 1][n + 1];

        // Base Case: If length of t reaches 0 in any case that means we found a
        // subsequence
        dp[0][0] = 1;
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 1;
        }
        // Base Case: If length of s reaches 0 before t reaching 0, means no subsequence
        // found
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}

public class DistinctSubsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        DistinctSubsequencesSol sol = new DistinctSubsequencesSol();
        System.out.println(sol.numDistinct(s, t));

        sc.close();
    }
}
