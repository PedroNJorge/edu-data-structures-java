import java.util.Scanner;
import java.util.Arrays;

public class ex088 {
    private static final int[][] DIRECTIONS = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1},     // up, down, left, right
        {-1, -1}, {-1, 1}, {1, -1}, {1, 1},   // upLeft, upRight, downLeft, downRight
    };

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int iter = s.nextInt();
        s.nextLine();

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = s.nextLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        s.close();

        // Life iterations
        for (int i = 0; i < iter; i++) {
            life(grid, n, m);
        }

        // Print grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    private static void life(char[][] grid, int n, int m) {
        // Copy grid
        char[][] copy = new char[n][];
        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(grid[i], m);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int numNeighbors = neighbors(copy, i, j, n, m);
                boolean isAlive = (copy[i][j] == 'O');

                if (isAlive) {
                    if (numNeighbors <= 1 || numNeighbors >= 4) grid[i][j] = '.';
                } else {
                    if (numNeighbors == 3) grid[i][j] = 'O';
                }
            }
        }
    }

    private static int neighbors(char[][] grid, int i, int j, int n, int m) {
        int num = 0;

        for (int[] dir : DIRECTIONS) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                if (grid[ni][nj] == 'O') num++;
            }
        }
        return num;
    }
}
