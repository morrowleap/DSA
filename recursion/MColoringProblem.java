/*
 * https://takeuforward.org/data-structure/m-coloring-problem/
 * https://youtu.be/wuVwUK25Rfc
 * https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
*/

package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MColoringProblem {
    boolean graphColoring(int v, List<int[]> edges, int m) {
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices (v): ");
        int v = sc.nextInt();

        System.out.print("Enter the number of edges (e): ");
        int e = sc.nextInt();

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new int[] { u, w });
        }

        System.out.print("Enter the maximum number of colors (m): ");
        int m = sc.nextInt();

        MColoringProblem sol = new MColoringProblem();
        boolean result = sol.graphColoring(v, edges, m);

        System.out.println("\nOutput:");
        if (result)
            System.out.println("The graph can be colored using " + m + " colors.");
        else
            System.out.println("The graph cannot be colored using " + m + " colors.");

        sc.close();
    }
}
