/*
 * https://takeuforward.org/data-structure/palindrome-partitioning/
 * https://youtu.be/WBgsABoClE0
 * 
 * https://leetcode.com/problems/palindrome-partitioning/description/
*/

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        PalindromePartitioning sol = new PalindromePartitioning();
        System.out.println(sol.partition(s));

        sc.close();
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        backtrack(s, 0, curr, res);

        return res;
    }

    private void backtrack(String s, int index, List<String> curr, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < s.length(); i++) {

            String substr = s.substring(index, i + 1);

            if (isPalindrome(substr)) {
                curr.add(substr);
                backtrack(s, i + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }

        // TODO: Attach recursion tree
    }

    private boolean isPalindrome(String substr) {
        int l = 0, r = substr.length() - 1;
        while (l < r) {
            if (substr.charAt(l) != substr.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

// Time Complexity Analysis: TODO not told in striver video
