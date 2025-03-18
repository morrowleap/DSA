/*
 * https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/
 * https://www.geeksforgeeks.org/problems/geek-jump/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=geek-jump
*/

package dynamic_programming;

import java.util.Scanner;

class FrogJumpSolution {
    private int topDownHelper(int n, int[] height, int[] memo) {
        if(n == 0) {
            return 0;
        }

        if(memo[n] != -1) {
            return memo[n];
        }

        int oneStep = Integer.MAX_VALUE, twoStep = Integer.MAX_VALUE;
        if(n - 1 >= 0) {
            oneStep = Math.abs(height[n] - height[n - 1]) + topDownHelper(n - 1, height, memo);
        }
        if(n - 2 >= 0) {
            twoStep = Math.abs(height[n] - height[n - 2]) + topDownHelper(n - 2, height, memo);
        }

        memo[n] = Math.min(oneStep, twoStep);
        return memo[n];
    }

    public int topDown(int[] height) {
        int n = height.length;
        int[] memo = new int[n];
        for(int i=0;i<n;i++) {memo[i]=-1;}
        return topDownHelper(n - 1, height, memo); 
    }

    public int bottomUp(int[] height) {
        int n = height.length;
        int[] memo = new int[n];

        memo[0] = 0;

        for(int i=1;i<n;i++) {
            int oneStep = Integer.MAX_VALUE, twoStep = Integer.MAX_VALUE;
            if(i - 1 >= 0) {
                oneStep = Math.abs(height[i] - height[i - 1]) + memo[i - 1];
            }
            if(i - 2 >= 0) {
                twoStep = Math.abs(height[i] - height[i - 2]) + memo[i - 2];
            }

            memo[i] = Math.min(oneStep, twoStep);
        }

        return memo[n - 1];
    }
}

public class FrogJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] heights = new int[n];
        for(int i=0;i<n;i++) {
            heights[i] = scanner.nextInt();
        }

        FrogJumpSolution sol = new FrogJumpSolution();
        System.out.println(sol.topDown(heights));
        System.out.println(sol.bottomUp(heights));
        
        scanner.close();
    }
} 