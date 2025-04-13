/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
*/

package recursion;

import java.util.List;
import java.util.Scanner;

public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String digits = sc.nextLine();

        LetterCombinationsOfAPhoneNumber sol = new LetterCombinationsOfAPhoneNumber();
        System.out.println(sol.letterCombinations(digits));

        sc.close();
    }
}
