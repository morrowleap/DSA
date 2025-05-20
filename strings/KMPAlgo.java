/*
 * http://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 * 
 * https://youtu.be/ynv7bbcSLKE
 * https://www.youtube.com/watch?v=V5-7GzOfADQ&t=720s
 * 
*/

package strings;

import java.util.Arrays;
import java.util.Scanner;

public class KMPAlgo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        KMPAlgo sol = new KMPAlgo();

        String pattern = "ABCDEFGAABCD"; // 0 0 0 0 0 0 0 1 1 2 3 4
        System.out.println(Arrays.toString(sol.prepareLPS(pattern.toCharArray())));
        pattern = "abcdabfabf"; // 0 0 0 0 1 2 0 1 2 0
        System.out.println(Arrays.toString(sol.prepareLPS(pattern.toCharArray())));
        pattern = "abcdeabfabc"; // 0 0 0 0 0 1 2 0 1 2 3
        System.out.println(Arrays.toString(sol.prepareLPS(pattern.toCharArray())));
        pattern = "aabcadaabe"; // 0 1 0 0 1 0 1 2 3 0
        System.out.println(Arrays.toString(sol.prepareLPS(pattern.toCharArray())));
        pattern = "aaaabaacd"; // 0 1 2 3 0 1 2 0 0
        System.out.println(Arrays.toString(sol.prepareLPS(pattern.toCharArray())));

        String str = "abxabcabcaby";
        pattern = "abcaby";
        System.out.println(sol.strStr(str, pattern));

        str = "aabaaabaaac";
        pattern = "aabaaac";
        System.out.println(sol.strStr(str, pattern));

        sc.close();
    }

    public int strStr(String haystack, String needle) {
        char[] source = haystack.toCharArray();
        char[] pattern = needle.toCharArray();

        int[] lps = prepareLPS(pattern);

        int completedPatterLen = 0;
        for (int i = 0; i < source.length; i++) {
            char c = source[i];

            if (c == pattern[completedPatterLen]) {
                completedPatterLen++;
                if (completedPatterLen == pattern.length) {
                    return i - completedPatterLen + 1;
                }
            } else {
                completedPatterLen = completedPatterLen > 0 ? lps[completedPatterLen - 1] : 0;
                if (c == pattern[completedPatterLen]) {
                    completedPatterLen++;
                }
            }
        }

        return -1;
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
