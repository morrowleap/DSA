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

#include <iostream>
#include <vector>

using namespace std;

int main() {
    const int N = 6;
    const int size = 2 * N - 1;
    vector<vector<int>> grid(size, vector<int>(size, 0));

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

    grid[size / 2][size / 2] = 1;

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            cout << grid[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}