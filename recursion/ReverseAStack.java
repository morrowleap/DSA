/*
 * https://practice.geeksforgeeks.org/problems/reverse-a-stack/1
*/

package recursion;

import java.util.Scanner;
import java.util.Stack;

public class ReverseAStack {
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

        ReverseAStack sol = new ReverseAStack();
        sol.printStack(stk);
        reverse(stk);
        sol.printStack(stk);

        sc.close();
    }

    public static void reverse(Stack<Integer> s) {
        topDown(s);
    }

    private static void topDown(Stack<Integer> stk) {
        if (stk.empty()) {
            return;
        }
        int top = stk.pop();
        topDown(stk);
        insert(stk, top);
    }

    /**
     * Inserts the element at bottom of stack
     */
    private static void insert(Stack<Integer> stk, int x) {
        if (stk.empty()) {
            stk.push(x);
            return;
        }
        int top = stk.pop();
        insert(stk, x);
        stk.push(top);
    }

    private void printStack(Stack<Integer> stk) {
        System.out.println(stk);
    }
}

// Time Complexity: O(N^2)
// Space Complexity: O(N)
