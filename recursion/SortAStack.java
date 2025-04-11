/*
 * https://www.geeksforgeeks.org/problems/sort-a-stack/1
*/

package recursion;

import java.util.Scanner;
import java.util.Stack;

public class SortAStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            stk.push(arr[i]);
        }

        SortAStack sol = new SortAStack();
        sol.printStack(stk);
        sol.sort(stk);
        sol.printStack(stk);

        sc.close();
    }

    public Stack<Integer> sort(Stack<Integer> s) {
        topDown(s);
        return s;
    }

    private void topDown(Stack<Integer> stk) {
        if (stk.empty()) {
            return;
        }
        int top = stk.pop();
        topDown(stk);
        sortedInsert(stk, top);
    }

    /**
     * Inserts the element at bottom of stack
     */
    private void sortedInsert(Stack<Integer> stk, int x) {
        if (stk.empty() || stk.peek() < x) {
            stk.push(x);
            return;
        }
        int top = stk.pop();
        sortedInsert(stk, x);
        stk.push(top);
    }

    private void printStack(Stack<Integer> stk) {
        System.out.println(stk);
    }
}

// Time Complexity: O(N^2)
// Space Complexity: O(N)
