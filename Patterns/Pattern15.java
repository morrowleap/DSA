/*
A B C D E F 
A B C D E 
A B C D 
A B C 
A B 
A 
*/

public class Pattern15 {
    public static void main(String[] args) {
        int N = 6;
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N - row + 1; col++) {
                System.out.print((char) ('A' + col - 1) + " ");
            }
            System.out.println();
        }
    }
}
