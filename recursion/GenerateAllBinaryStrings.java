/*
 * https://www.geeksforgeeks.org/problems/generate-all-binary-strings/1
 * 
*/

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateAllBinaryStrings {

    public static List<String> generateBinaryStrings(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        topDown(n, curr, res);

        return res;
    }

    private static void topDown(int n, StringBuilder curr, List<String> res) {
        if (n == 0) {
            res.add(curr.toString());
            return;
        }

        curr.append('0');
        topDown(n - 1, curr, res);
        curr.deleteCharAt(curr.length() - 1);

        if (curr.length() == 0 || curr.charAt(curr.length() - 1) != '1') {
            curr.append('1');
            topDown(n - 1, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(generateBinaryStrings(n));

        sc.close();
    }
}

// Recursive Time Complexity: At each step we have 2 coices, O(2^N)
// Recursive Space Complexity: Stack space goes till O(N)

// Space complexity: O(N * 2^N + N), Since we store 2^N string of length N and a
// recursion stackspace of length N
