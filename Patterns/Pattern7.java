/*
          * 
        * * * 
      * * * * * 
    * * * * * * * 
  * * * * * * * * * 
* * * * * * * * * * * 
*/

public class Pattern7 {
    public static void main(String[] args) {
        int n = 6;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row; col++) {
                System.out.print("  ");
            }
            for (int col = 1; col <= (row * 2) - 1; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}