package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

class LongestCommonSubsequenceSol {

    public int topDown(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return topDownHelper(text1, m - 1, text2, n - 1, memo);
    }

    private int topDownHelper(String text1, int m, String text2, int n, int[][] memo) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        if (text1.charAt(m) == text2.charAt(n)) {
            return 1 + topDownHelper(text1, m - 1, text2, n - 1, memo);
        }

        int check1 = topDownHelper(text1, m - 1, text2, n, memo);
        int check2 = topDownHelper(text1, m, text2, n - 1, memo);

        memo[m][n] = Math.max(check1, check2);
        return memo[m][n];
    }

}

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text1 = sc.nextLine();
        String text2 = sc.nextLine();

        LongestCommonSubsequenceSol sol = new LongestCommonSubsequenceSol();
        System.out.println(sol.topDown(text1, text2));

        sc.close();
    }
}
