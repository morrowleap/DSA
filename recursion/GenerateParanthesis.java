/*
 * https://leetcode.com/problems/generate-parentheses/description/
*/

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParanthesis {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        GenerateParanthesis sol = new GenerateParanthesis();
        System.out.println(sol.generateParenthesis(n));

        sc.close();
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder curr = new StringBuilder();
        List<String> res = new ArrayList<>();

        backtrack(n, n, curr, res);
        return res;
    }

    private void backtrack(int open, int close, StringBuilder curr, List<String> res) {
        if (open == 0 && close == 0) {
            res.add(curr.toString());
            return;
        }

        if (open > 0) { // Open brackets are remaining
            curr.append('(');
            backtrack(open - 1, close, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (open < close) { // More open brackets are used than closed brackets
            curr.append(')');
            backtrack(open, close - 1, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }

        // TODO: Attach recursion tree
    }
}

// Recursive Time Complexity: At each step we have 2 coices, O(2^N)
// Recursive Space Complexity: Stack space goes till O(2N)

// Overall Space complexity: O(2N * 2^N + 2N), Since we store 2^N string of
// length 2N
// and
// a recursion stackspace of length 2N
