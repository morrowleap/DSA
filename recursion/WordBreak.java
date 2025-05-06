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
        return backtrack(s, s.length(), 0, words);
    }

    private boolean backtrack(String s, int n, int index, HashSet<String> words) {
        if (index == n) {
            return true;
        }

        for (int i = index; i < n; i++) {
            String sstr = s.substring(index, i + 1);
            if (words.contains(sstr)) {
                if (backtrack(s, n, i + 1, words) == true) {
                    return true;
                }
            }
        }

        return false;
    }
}

// Time Complexity: O(2 ^ N), O(N) for memoized
// Space Complexity: O(N)
