/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
*/

package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        Map<Character, String> keyMapping = new HashMap<Character, String>() {
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

        StringBuilder curr = new StringBuilder();
        List<String> res = new ArrayList<>();
        topDown(keyMapping, digits, 0, curr, res);

        return res;
    }

    private void topDown(Map<Character, String> keyMapping, String digits, int i, StringBuilder curr,
            List<String> res) {
        if (i == digits.length()) {
            if (!curr.isEmpty()) {
                res.add(curr.toString());
            }
            return;
        }

        for (char x : keyMapping.get(digits.charAt(i)).toCharArray()) {
            curr.append(x);
            topDown(keyMapping, digits, i + 1, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String digits = sc.nextLine();

        LetterCombinationsOfAPhoneNumber sol = new LetterCombinationsOfAPhoneNumber();
        System.out.println(sol.letterCombinations(digits));

        sc.close();
    }
}
