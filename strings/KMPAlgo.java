/*
 * http://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 * 
 * 
*/

package strings;

import java.util.Arrays;
import java.util.Scanner;

public class KMPAlgo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "abxabcabcaby";
        String pattern = "abcaby";

        KMPAlgo sol = new KMPAlgo();
        System.out.println(Arrays.toString(sol.prepareLPS(pattern.toCharArray())));
        // System.out.println(sol.strStr(str, pattern));

        sc.close();
    }

    private int[] prepareLPS(char[] pattern) {
        // Prepare Longest Proper Prefix which is also a Suffix array
        // A B C D E F G A A B C D
        // 0 0 0 0 0 0 0 1 1 2 3 4
        // This means that at an index i I have lps[i] length of prefix which matches in
        // the starting of array

        // means at D = 4, means ABCD also present at start
        int[] lps = new int[pattern.length];

        int subPatternLen = 0;
        int i = 1;
        while (i < pattern.length) {
            if (pattern[subPatternLen] == pattern[i]) {
                lps[i] = subPatternLen + 1;
                subPatternLen++;
            } else {
                subPatternLen = 0;
                if (pattern[subPatternLen] == pattern[i]) {
                    lps[i] = 1;
                    subPatternLen = 1;
                }
            }
            i++;
        }

        return lps;
    }
}
