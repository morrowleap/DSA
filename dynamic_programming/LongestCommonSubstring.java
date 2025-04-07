/*
 * https://takeuforward.org/data-structure/longest-common-substring-dp-27/
 * https://www.geeksforgeeks.org/problems/longest-common-substring1452/1 go to editorial video
*/

package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

class LongestCommonSubstringSol {

    public int longestCommonSubstr(String text1, String text2) {
        return bottomUp(text1, text2);
    }

    private int bottomUp(String text1, String text2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bottomUp'");
    }

    private void topDown(String text1, int i, String text2, int j, int[][] memo) {
        /*
         * On internet i am only able to find bottom up approach for this question
         * ChatGPT said:
         * Reasoned about top-down vs bottom-up approaches for 9 seconds
         * The top-down approach is less common because tracking the
         * "current matching count" is tricky with recursion, and overlapping
         * subproblems are handled more naturally using bottom-up iteration.
         */

        // TODO: top down approach not understood
        throw new UnsupportedOperationException("Unimplemented method 'topDown'");
    }

}

public class LongestCommonSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text1 = sc.next();
        String text2 = sc.next();

        LongestCommonSubstringSol sol = new LongestCommonSubstringSol();
        System.out.println(sol.longestCommonSubstr(text1, text2));

        sc.close();
    }
}
