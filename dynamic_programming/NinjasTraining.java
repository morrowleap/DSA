package dynamic_programming;

import java.util.Scanner;

class NinjasTrainingSolution {
    private int topDownHelper(int n, int last, int[][] arr, int[][] memo) {
        if(n == 0) {
            return 0;
        }

        if(memo[n][last] != -1) {
            return memo[n][last];
        }

        int maxPoints = Integer.MIN_VALUE;
        for(int activity=0;activity<3;activity++) {
            if(activity != last) {
                int points = arr[n - 1][activity] + topDownHelper(n - 1, activity, arr, memo);
                maxPoints = Math.max(maxPoints, points);
            }
        }

        memo[n][last] = maxPoints;
        return maxPoints;
    }

    public int topDown(int[][] arr) {
        int n = arr.length;
        int[][] memo = new int[n+1][4];
        for(int i=0;i<=n;i++) {
            for(int j=0;j<4;j++) {
                memo[i][j] = -1;
            }
        }
        
        return topDownHelper(n, 3, arr, memo);
    }

    public int bottomUp(int[][] arr) {
        int n = arr.length;
        int[][] memo = new int[n+1][4];

        for(int day=1;day<n;day++) {
            for(int todayActivity=0;todayActivity<3;todayActivity++) {

                int maxPoints = Integer.MIN_VALUE;

                for(int nextActivity=0;nextActivity<3;nextActivity++) {
                    if(nextActivity != todayActivity) {
                        int points = arr[day - 1][nextActivity] + memo[day - 1][nextActivity];
                        maxPoints = Math.max(maxPoints, points);
                    }
                }

                memo[day][todayActivity] = maxPoints;
            }
        }

        int day = n;
        int maxPoints = Integer.MIN_VALUE;
        for(int activity=0;activity<3;activity++) {
            int points = arr[day - 1][activity] + memo[day - 1][activity];
            maxPoints = Math.max(maxPoints, points);
        }
        memo[day][3] = maxPoints;

        return maxPoints;
    }
}

public class NinjasTraining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] arr = new int[n][3];
        for(int i=0;i<n;i++) {
            for(int j=0;j<3;j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        NinjasTrainingSolution sol = new NinjasTrainingSolution();
        System.out.println(sol.topDown(arr));
        System.out.println(sol.bottomUp(arr));

        scanner.close();
    }
}