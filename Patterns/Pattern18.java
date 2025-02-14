/*
F
E F
D E F
C D E F
B C D E F
A B C D E F
*/

public class Pattern18 {
    public static void main(String[] args) {
        int N = 6;
        for (int row = 1; row <= N; row++) {
            for (int col = row; col >= 1; col--) {
                System.out.print((char) ('A' + N - col) + " ");
            }
            System.out.println();
        }
    }
}
