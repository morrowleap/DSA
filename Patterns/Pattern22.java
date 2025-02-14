/*
6 6 6 6 6 6 6 6 6 6 6
6 5 5 5 5 5 5 5 5 5 6
6 5 4 4 4 4 4 4 4 5 6
6 5 4 3 3 3 3 3 4 5 6
6 5 4 3 2 2 2 3 4 5 6
6 5 4 3 2 1 2 3 4 5 6
6 5 4 3 2 2 2 3 4 5 6
6 5 4 3 3 3 3 3 4 5 6
6 5 4 4 4 4 4 4 4 5 6
6 5 5 5 5 5 5 5 5 5 6
6 6 6 6 6 6 6 6 6 6 6
*/

public class Pattern22 {
    public static void main(String[] args) {
        final int N = 6;
        final int size = 2 * N - 1;
        int[][] grid = new int[size][size];

        int x = -1, y = -1;
        for (int num = N; num >= 1; num--) {
            x++;
            y++;
            for (int i = 1; i <= 2 * num - 2; i++) {
                y++;
                grid[x][y] = num;
            }
            for (int i = 1; i <= 2 * num - 2; i++) {
                x++;
                grid[x][y] = num;
            }
            for (int i = 1; i <= 2 * num - 2; i++) {
                y--;
                grid[x][y] = num;
            }
            for (int i = 1; i <= 2 * num - 2; i++) {
                x--;
                grid[x][y] = num;
            }
        }

        grid[size/2][size/2] = 1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
