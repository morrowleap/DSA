/*
 * http://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 * 
 * 
*/

package strings;

import java.util.Arrays;
// import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Scanner;

public class KMPAlgoAvi {
    public int strStr(String haystack, String needle) {
        char[] source = haystack.toCharArray();
        char[] pattern = needle.toCharArray();

        int[] lps = prepareLPS(pattern);
        // ArrayList<Integer> answers = new ArrayList<Integer>();

        int srcPtr = 0, pttrnPtr = 0;
        while (srcPtr < source.length) {
            // System.out.println(source[srcPtr]);
            if (source[srcPtr] == pattern[pttrnPtr]) {
                System.out.println("matched => "+source[srcPtr]);
                // we got one answer
                if (pttrnPtr == pattern.length - 1) {
                    return srcPtr - pattern.length;
                    // answers.add(srcPtr-pattern.length);

                    // // I am still inside the pttrn array. Last element.
                    // srcPtr ++;
                    // pttrnPtr = lps[pttrnPtr];
                    // continue;
                }
                pttrnPtr++;

            } else {
                pttrnPtr = pttrnPtr > 0 ? lps[pttrnPtr - 1] + 1 : 0;
            }

            srcPtr++;
        }

        return 0;
        // return answers.get(0);
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

        KMPAlgoAvi sol = new KMPAlgoAvi();
        System.out.println(Arrays.toString(sol.prepareLPS(pattern.toCharArray())));
        System.out.println(sol.strStr(str, pattern));

        sc.close();
    }
}
