/*
1          1
12        21
12       321
1234    4321
12345  54321
123456654321
*/

public class Pattern12 {
    public static void main(String[] args) {
        int n = 6;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            for (int col = 1; col <= (n - row) * 2; col++) {
                System.out.print("  ");
            }
            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
