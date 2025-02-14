/*
 1 
 0 1 
 1 0 1 
 0 1 0 1 
 1 0 1 0 1 
 0 1 0 1 0 1 
*/

public class Pattern11 {
    public static void main(String[] args) {
        int n = 6;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print((col + row - 1) % 2 + " ");
            }
            System.out.println();
        }
    }
}
