/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
*/

package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String digits = sc.nextLine();

        LetterCombinationsOfAPhoneNumber sol = new LetterCombinationsOfAPhoneNumber();
        System.out.println(sol.letterCombinations(digits));

        sc.close();
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        HashMap<Character, String> keyMapping = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };

        List<String> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        backtrack(digits, 0, keyMapping, curr, res);

        return res;
    }

    /**
     * For loop Generating subsets
     */
    public void backtrack(String digits, int index, HashMap<Character, String> keyMapping, StringBuilder curr,
            List<String> res) {
        if (index == digits.length()) {
            res.add(curr.toString());
            return;
        }

        char c = digits.charAt(index);

        for (char x : keyMapping.get(c).toCharArray()) {
            curr.append(x);
            backtrack(digits, index + 1, keyMapping, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }

        // TODO: Add recursion tree
    }
}

// Recursive Time Complexity: O(4^N)
// Recursive Space Complexity: O(N)

// Overall Time Complexity: O(4^N * N), The extra *N comes from copying each
// string of length N when adding it to the result list.

// Overall Space complexity: O(N + 4^N * N), Each result has length N, and there
// are
// up to 4^N combinations, so storing the results requires O(4^N * N) space.
// Additionally, the recursion stack uses O(N) space.
