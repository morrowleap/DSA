/*
          A 
        A B A 
      A B C B A 
    A B C D C B A 
  A B C D E D C B A 
A B C D E F E D C B A
*/

public class Pattern17 {
    public static void main(String[] args) {
        int N = 6;
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N - row; col++) {
                System.out.print("  ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print((char) ('A' + col - 1) + " ");
            }
            for (int col = row - 1; col >= 1; col--) {
                System.out.print((char) ('A' + col - 1) + " ");
            }
            System.out.println();
        }
    }
}
