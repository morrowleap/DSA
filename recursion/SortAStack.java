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

    private void sort(Stack<Integer> stk) {
        if (stk.isEmpty()) {
            return;
        }

        int x = stk.pop();
        sort(stk);
        insertSorted(stk, x);
    }

    private void insertSorted(Stack<Integer> stk, int ele) {
        if (stk.isEmpty() || stk.peek() < ele) {
            stk.push(ele);
            return;
        }

        int x = stk.pop();
        insertSorted(stk, ele);
        stk.push(x);
    }

    private void printStack(Stack<Integer> stk) {
        System.out.println(stk);
    }

}

// Time Complexity: O(N^2)
// Space Complexity: O(N)
