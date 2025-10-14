import java.util.Scanner;
import java.util.ArrayList;

public class ex015 {
    private static final int[][] DIRECTIONS = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1},     // up, down, left, right
    };

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int NUM = 1;
        int LINS = 1;
        int COLS = 1;

        while (true) {
            LINS = s.nextInt();
            COLS = s.nextInt();
            if (LINS == 0 && COLS == 0) break;
            s.nextLine();

            // Read grid
            char[][] board = new char[LINS][COLS];
            for (int i = 0; i < LINS; i++) {
                String line = s.nextLine();
                for (int j = 0; j < COLS; j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            // Read words
            int n = s.nextInt();
            s.nextLine();
            ArrayList<String> words = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = s.nextLine();
                words.add(line);
            }

            char[][] final_grid = solve(board, words, LINS, COLS);
            // Print grid
            System.out.printf("Input #%d\n", NUM);
            NUM++;
            for (int i = 0; i < LINS; i++) {
                for (int j = 0; j < COLS; j++) {
                    System.out.print(final_grid[i][j]);
                }
                System.out.println();
            }
        }
        s.close();
    }

    private static char[][] solve(char[][] board, ArrayList<String> words, int LINS, int COLS) {
        char[][] final_grid= new char[LINS][COLS];
        for (int i = 0; i < LINS; i++) {
            for (int j = 0; j < COLS; j++) {
                final_grid[i][j] = '.';
            }
        }

        // Search every word
        for (String word : words) {
            boolean found = false;
            for (int i = 0; i < LINS && !found; i++) {
                for (int j = 0; j < COLS && !found; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        for (int[] dir : DIRECTIONS) {
                            boolean[][] visited = new boolean[LINS][COLS];
                            if (dfs(board, word, i, j, dir[0], dir[1], visited, 0)) { // Found word
                                for (int x = 0; x < LINS; x++) {
                                    for (int y = 0; y < COLS; y++) {
                                        if (visited[x][y]) final_grid[x][y] = board[x][y];
                                    }
                                }
                                found = true;
                            }
                        }
                    }
                }
            }
        }
        return final_grid;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int di, int dj, boolean[][] visited, int index) {
        if (index == word.length()) return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        if (board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (dfs(board, word, i + di, j + dj, di, dj, visited, index + 1)) return true;
        visited[i][j] = false;
        return false;
    }
}
