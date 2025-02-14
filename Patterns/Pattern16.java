/*
A 
B B 
C C C 
D D D D 
E E E E E 
F F F F F F 
*/

public class Pattern16 {
    public static void main(String[] args) {
        int N = 6;
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print((char) (row + 'A' - 1) + " ");
            }
            System.out.println();
        }
    }
}
