/*
 * https://leetcode.com/problems/expression-add-operators/description/
 * https://algo.monster/liteproblems/282
 * https://leetcode.com/problems/expression-add-operators/submissions/
 * 1498810068/
 * 
 * https://youtu.be/WcgjFrZceU8
 * 
 * https://youtu.be/S6OG5pGWxIw
 * 
 * https://algo.monster/liteproblems/282
 * 
 */

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        topDown(num, 0, 0, 0, target, new StringBuilder(), res);
        return res;
    }

    private void topDown(String num, int index, long prevOperand, long currTotal, int target,
            StringBuilder curr, List<String> res) {
        if (index == num.length()) {
            if (currTotal == target)
                res.add(curr.toString());
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0')
                break;
            String sstr = num.substring(index, i + 1);
            long nextOperand = Long.parseLong(sstr);
            int len = curr.length();
            if (index == 0) {
                curr.append(sstr);
                topDown(num, i + 1, nextOperand, nextOperand, target, curr, res);
                curr.setLength(len);
            } else {
                curr.append('+').append(sstr);
                topDown(num, i + 1, nextOperand, currTotal + nextOperand, target, curr, res);
                curr.setLength(len);

                curr.append('-').append(sstr);
                topDown(num, i + 1, -nextOperand, currTotal - nextOperand, target, curr, res);
                curr.setLength(len);

                curr.append('*').append(sstr);
                topDown(num, i + 1, prevOperand * nextOperand,
                        (currTotal - prevOperand) + (prevOperand * nextOperand), target, curr, res);
                curr.setLength(len);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num = sc.nextLine();
        int target = sc.nextInt();

        ExpressionAddOperators sol = new ExpressionAddOperators();
        System.out.println(sol.addOperators(num, target));

        sc.close();
    }
}
