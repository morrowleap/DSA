/*
 * https://leetcode.com/problems/word-break/description/
*/

package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();

        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        return topDown(s, 0, wordSet, memo);
    }

    private boolean topDown(String s, int index, Set<String> wordSet, int[] memo) {
        if (index == s.length()) {
            return true;
        }

        if (memo[index] != -1) {
            return memo[index] == 1 ? true : false;
        }

        for (int i = index; i < s.length(); i++) {
            String x = s.substring(index, i + 1);
            if (wordSet.contains(x) && topDown(s, i + 1, wordSet, memo)) {
                memo[index] = 1;
                return true;
            }
        }

        memo[index] = 0;
        return false;

        // TODO: Add recursion tree
    }

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
}

// Time Complexity: O(2 ^ N)
// Space Complexity: O(N)
