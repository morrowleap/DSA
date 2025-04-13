/*
 * https://takeuforward.org/data-structure/palindrome-partitioning/
 * https://leetcode.com/problems/palindrome-partitioning/description/
 * https://youtu.be/WBgsABoClE0
*/

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromePartitioning {

    private List<List<String>> partition(String s) {
        List<String> curr = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        topDown(s, 0, curr, res);

        return res;
    }

    private void topDown(String s, int index, List<String> curr, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                curr.add(s.substring(index, i + 1));
                topDown(s, i + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }

        // TODO: Attach recursion tree
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        PalindromePartitioning sol = new PalindromePartitioning();
        System.out.println(sol.partition(s));

        sc.close();
    }
}

// Time Complexity Analysis: TODO not told in striver video
