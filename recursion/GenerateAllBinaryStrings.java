/*
 * https://www.geeksforgeeks.org/problems/generate-all-binary-strings/1
 * 
*/

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateAllBinaryStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(generateBinaryStrings(n));

        sc.close();
    }

    public static List<String> generateBinaryStrings(int N) {
        StringBuilder curr = new StringBuilder();
        List<String> res = new ArrayList<>();

        backtrack(N, curr, res);
        return res;
    }

    private static void backtrack(int N, StringBuilder curr, List<String> res) {
        if (curr.length() == N) {
            res.add(curr.toString());
            return;
        }

        curr.append('0');
        backtrack(N, curr, res);
        curr.deleteCharAt(curr.length() - 1);

        if (curr.length() == 0 || curr.charAt(curr.length() - 1) == '0') {
            curr.append('1');
            backtrack(N, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }

        // TODO: Attach recursion tree

        // There are 2 choices in pick either 0 or 1. It is not a pick and not pick
        // solution
    }
}

// Recursive Time Complexity: At each step we have 2 coices, O(2^N)
// Recursive Space Complexity: Stack space goes till O(N)

// Overall Space complexity: O(N * 2^N + N), Since we store 2^N string of length
// N and a
// recursion stackspace of length N
