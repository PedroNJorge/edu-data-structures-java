import java.util.Scanner;

public class ex101 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int flag = s.nextInt();
        s.nextLine();
        int LINS = s.nextInt();
        int COLS = s.nextInt();
        s.nextLine();

        // Init grid
        char[][] grid = new char[LINS][COLS];
        for (int i = 0; i < LINS; i++) {
            for (int j = 0; j < COLS; j++) {
                grid[i][j] = '.';
            }
        }

        // Parse Turtle commands
        Turtle t = new Turtle();
        while (true) {
            String line = s.nextLine().trim();
            if (line.equals("end")) break;
            t.parse(grid, LINS, COLS, line);
        }

        // Read pattern
        int n = s.nextInt();
        int m = s.nextInt();
        s.nextLine();

        char[][] pattern = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = s.nextLine();
            for (int j = 0; j < m; j++) {
                pattern[i][j] = line.charAt(j);
            }
        }

        switch (flag) {
            case 0:
                printGrid(grid, LINS, COLS);
                break;

            case 1:
                int[] stats = gridStats(grid, LINS, COLS);
                int percentage = stats[0];
                int linesEmpty = stats[1];
                int colsEmpty = stats[2];
                System.out.printf("%d %d %d\n", percentage, linesEmpty, colsEmpty);
                break;

            case 2:
                break;
        }
    }

    private static void printGrid(char[][] grid, int LINS, int COLS) {
        for (int i = 0; i < LINS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(grid[i][j]);
                if (j < COLS - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static int[] gridStats(char[][] grid, int LINS, int COLS) {
        int percentage;
        int markedCells = 0, linesEmpty = 0, colsEmpty = 0;
        
        // Empty cells and lines
        for (int i = 0; i < LINS; i++) {
            boolean isEmpty = true;
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] != '.') {
                    isEmpty = false;
                    markedCells++;
                }
            }
            if (isEmpty) linesEmpty++;
        }

        // Empty cols
        for (int j = 0; j < COLS; j++) {
            boolean isEmpty = true;
            for (int i = 0; i < LINS; i++) {
                if (grid[i][j] != '.') {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) colsEmpty++;
        }

        percentage = 100*markedCells / (LINS * COLS);
        int[] result = {percentage, linesEmpty, colsEmpty};
        return result;
    }

    private static boolean patternSearch(char[][] grid, int LINS, int COLS, char[][] pattern, int n, int m) {
        return true;
    }
}

class Turtle {
    int x, y;
    int dir; // N, E, S, O <- mod 4
    boolean penDown;

    public Turtle() {
        x = y = 0;
        dir = 1;
        penDown = false;
    }

    void parse(char[][] grid, int LINS, int COLS, String line) {
        if (line.startsWith("F")) {
            int steps = Integer.parseInt(line.substring(2).trim());
            this.move(grid, LINS, COLS, steps);

        } else {
            switch (line.charAt(0)) {
                case 'U':
                    this.penDown = false;
                    break;

                case 'D':
                    this.penDown = true;
                    grid[y][x] = '*';
                    break;

                case 'L':
                    this.dir = (this.dir + 3) % 4;
                    break;

                case 'R':
                    this.dir = (this.dir + 1) % 4;
                    break;
            }
        }
    }

    void move(char[][] grid, int LINS, int COLS, int n) {
        for (int i = 0; i < n; i++) {
            int nextX = this.x, nextY = this.y;
            switch (this.dir) {
                case 0: nextY--; break; // Norte
                case 1: nextX++; break; // Este
                case 2: nextY++; break; // Sul
                case 3: nextX--; break; // Oeste
            }

            if (nextX >= 0 && nextX < COLS && nextY >= 0 && nextY < LINS) {
                x = nextX;
                y = nextY;
                
                if (penDown) {
                    grid[y][x] = '*';
                }
            } else {
                break;
            }
        }
    }
}
