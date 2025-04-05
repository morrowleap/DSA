/*
 * https://takeuforward.org/data-structure/print-longest-common-subsequence-dp-26/
 * https://www.geeksforgeeks.org/problems/print-all-lcs-sequences3413/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=print-all-lcs-sequences
 * https://www.geeksforgeeks.org/print-longest-common-sub-sequences-lexicographical-order/
*/

package dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class PrintLongestCommonSubsequenceSol {

    public String print_longest_common_subsequence(String text1, String text2) {
        int[][] dp = bottomUp(text1, text2);

        int m = dp.length - 1;
        int n = dp[0].length - 1;

        StringBuilder result = new StringBuilder();
        while (m != 0 && n != 0) {
            if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
                result.append(text1.charAt(m - 1));
                m--;
                n--;
            } else {
                if (dp[m - 1][n] > dp[m][n - 1]) {
                    m--;
                } else {
                    n--;
                }
            }
        }
        return result.reverse().toString();
    }

    public List<String> all_longest_common_subsequences(String text1, String text2) {
        int[][] dp = bottomUp(text1, text2);
        int m = dp.length - 1;
        int n = dp[0].length - 1;

        HashSet<String> res = new HashSet<>();
        backtrack(text1, m, text2, n, dp, new StringBuilder(), res);

        List<String> resultList = new ArrayList<>(res);
        Collections.sort(resultList);
        return resultList;
    }

    public List<String> all_longest_common_subsequences_2(String text1, String text2) {
        // TODO: not understood yet
        // https://www.geeksforgeeks.org/print-longest-common-sub-sequences-lexicographical-order/
        return null;
    }

    private void backtrack(String text1, int m, String text2, int n, int[][] dp, StringBuilder sb,
            HashSet<String> res) {
        if (m == 0 || n == 0) {
            res.add(sb.reverse().toString());
            sb.reverse();
            return;
        }

        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            sb.append(text1.charAt(m - 1));
            backtrack(text1, m - 1, text2, n - 1, dp, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            if (dp[m - 1][n] >= dp[m][n - 1])
                backtrack(text1, m - 1, text2, n, dp, sb, res);
            if (dp[m][n - 1] >= dp[m - 1][n])
                backtrack(text1, m, text2, n - 1, dp, sb, res);
        }
    }

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
}

public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text1 = sc.nextLine();
        String text2 = sc.nextLine();

        PrintLongestCommonSubsequenceSol sol = new PrintLongestCommonSubsequenceSol();
        String result = sol.print_longest_common_subsequence(text1, text2);
        System.out.println(result);

        sc.close();
    }
}
