/*
 * https://takeuforward.org/data-structure/print-longest-common-subsequence-dp-26/
 * https://www.geeksforgeeks.org/problems/print-all-lcs-sequences3413/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=print-all-lcs-sequences
*/

package dynamic_programming;

import java.util.List;
import java.util.Scanner;

class PrintLongestCommonSubsequenceSol {

    public List<String> all_longest_common_subsequences(String text1, String text2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'all_longest_common_subsequences'");
    }
}

public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text1 = sc.nextLine();
        String text2 = sc.nextLine();

        PrintLongestCommonSubsequenceSol sol = new PrintLongestCommonSubsequenceSol();
        List<String> result = sol.all_longest_common_subsequences(text1, text2);

        for (String x : result) {
            System.out.println(x);
        }

        sc.close();
    }
}
