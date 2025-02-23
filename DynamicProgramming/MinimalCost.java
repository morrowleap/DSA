import java.util.Scanner;

class Solution {
    private int topDownHelper(int n, int k, int[] arr) {
        if(n == 0) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for(int jump = 1; jump <= k; jump++) {
            if(n - jump >= 0) {
                int cost = Math.abs(arr[n] - arr[n - jump]) + topDownHelper(n - jump, k, arr);
                minCost = Math.min(minCost, cost);
            }
        }
        return minCost;
    }

    public int topDown(int k, int[] arr) {
        int n = arr.length;
        return topDownHelper(n - 1, k, arr);
    }
}

public class MinimalCost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] heights = new int[n];
        for(int i=0;i<n;i++) {
            heights[i] = scanner.nextInt();
        }

        Solution sol = new Solution();
        System.out.println(sol.topDown(k, heights));

        scanner.close();
    }
}