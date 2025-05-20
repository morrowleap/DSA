/*
 * http://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 * 
 * 
*/

package strings;

import java.util.Arrays;
import java.util.Scanner;

public class KMPAlgo {
    public int strStr(String haystack, String needle) {
        char[] source = haystack.toCharArray();
        char[] pattern = needle.toCharArray();

        int[] lps = prepareLPS(pattern);

        int srcPtr = 0, pttrnPtr = 0;
        while (srcPtr < source.length) {
            if (pttrnPtr == pattern.length) {
                return srcPtr;
            }
            if (source[srcPtr] == pattern[pttrnPtr]) {
                srcPtr++;
                pttrnPtr++;
            } else {
                if (pttrnPtr > 0) {
                    pttrnPtr = lps[pttrnPtr - 1];
                    
                }
            }
        }

        return 0;
    }

    public int[] prepareLPS(char[] pattern) {
        int[] lps = new int[pattern.length];
        int i = 1;
        int alreadyMatchedPrefixLen = 0;

        while (i < pattern.length) {
            if (pattern[i] == pattern[alreadyMatchedPrefixLen]) {
                lps[i] = alreadyMatchedPrefixLen + 1;
                alreadyMatchedPrefixLen++;
                i++;
            } else {
                alreadyMatchedPrefixLen = 0;
                lps[i] = 0;
                if (pattern[i] == pattern[0]) {
                    lps[i] = 1;
                    alreadyMatchedPrefixLen = 1;
                }
                i++;
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "abxabcabcaby";
        String pattern = "abcaby";

        KMPAlgo sol = new KMPAlgo();
        System.out.println(Arrays.toString(sol.prepareLPS(pattern.toCharArray())));
        System.out.println(sol.strStr(str, pattern));

        sc.close();
    }
}
