import java.util.Scanner;

class Solution {
    private int topDownHelper(int n, int[] height) {
        if(n <= 0) {
            return 0;
        }
        
        int oneStep = Integer.MAX_VALUE, twoStep = Integer.MAX_VALUE;
        if(n - 1 >= 0) {
            oneStep = Math.abs(height[n] - height[n - 1]) + topDownHelper(n - 1, height);
        }
        if(n - 2 >= 0) {
            twoStep = Math.abs(height[n] - height[n - 2]) + topDownHelper(n - 2, height);
        }

        return Math.min(oneStep, twoStep);
    }

    private int topDown(int[] height) {
        int n = height.length;
        return topDownHelper(n - 1, height);
    }
}

public class FrogJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] height = {20, 30, 40, 20};
        int n = height.length;

        Solution sol = new Solution();
        System.out.println(sol.topDown(height));

        scanner.close();
    }
}
