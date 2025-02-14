/*
A 
A B 
A B C 
A B C D 
A B C D E 
A B C D E F
*/

public class Pattern14 {
    public static void main(String[] args) {
        int n = 6;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print((char) (col + (int) 'A' - 1) + " ");
            }
            System.out.println();
        }
    }
}
