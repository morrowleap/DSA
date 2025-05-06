/*
 * https://leetcode.com/problems/word-break/description/
 * https://youtu.be/3ao_ms-bT9M
*/

package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class WordBreak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int n = sc.nextInt();
        List<String> wordDict = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            wordDict.add(sc.nextLine());
        }

        WordBreak sol = new WordBreak();
        System.out.println(sol.wordBreak(s, wordDict));

        sc.close();
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> words = new HashSet<>(wordDict);
        int n = s.length();

        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = -1;
        }

        return backtrack(s, s.length(), 0, words, memo);
    }

    private boolean backtrack(String s, int n, int index, HashSet<String> words, int[] memo) {
        if (index == n) {
            return true;
        }

        if (memo[index] != -1) {
            return memo[index] == 1 ? true : false;
        }

        for (int i = index; i < n; i++) {
            String sstr = s.substring(index, i + 1);
            if (words.contains(sstr)) {
                if (backtrack(s, n, i + 1, words, memo) == true) {
                    memo[index] = 1;
                    return true;
                }
            }
        }

        memo[index] = 0;
        return false;
    }
}

// Time Complexity: O(2 ^ N), O(N) for memoized
// Space Complexity: O(N)
