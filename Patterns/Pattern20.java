/*
*                     * 
* *                 * * 
* * *             * * * 
* * * *         * * * * 
* * * * *     * * * * * 
* * * * * * * * * * * * 
* * * * * * * * * * * * 
* * * * *     * * * * * 
* * * *         * * * * 
* * *             * * * 
* *                 * * 
*                     * 
*/

public class Pattern20 {
    public static void main(String[] args) {
        int N = 6;
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            for (int col = 1; col <= (N - row) * 2; col++) {
                System.out.print("  ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int row = N; row >= 1; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            for (int col = 1; col <= (N - row) * 2; col++) {
                System.out.print("  ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
