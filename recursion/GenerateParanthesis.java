/*
 * https://leetcode.com/problems/generate-parentheses/description/
*/

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        topDown(n, n, curr, res);
        return res;
    }

    private void topDown(int openN, int closeN, StringBuilder curr, List<String> res) {
        if (openN == 0 && closeN == 0) {
            res.add(curr.toString());
            return;
        }

        if (openN > 0) { // Open brackets are remaining
            curr.append('(');
            topDown(openN - 1, closeN, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (openN < closeN) { // More open brackets are used than closed brackets
            curr.append(')');
            topDown(openN, closeN - 1, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        GenerateParanthesis sol = new GenerateParanthesis();
        System.out.println(sol.generateParenthesis(n));

        sc.close();
    }
}

// Recursive Time Complexity: At each step we have 2 coices, O(2^N)
// Recursive Space Complexity: Stack space goes till O(2N)

// Space complexity: O(2N * 2^N + 2N), Since we store 2^N string of length 2N
// and
// a recursion stackspace of length 2N
