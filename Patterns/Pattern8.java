/*
* * * * * * * * * * * 
  * * * * * * * * * 
    * * * * * * * 
      * * * * * 
        * * * 
          * 
*/

public class Pattern8 {
    public static void main(String[] args) {
        int n = 6;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row - 1; col++) {
                System.out.print("  ");
            }
            for (int col = 1; col <= (n - row + 1) * 2 - 1; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
