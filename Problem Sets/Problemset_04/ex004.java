import java.util.Scanner;

public class ex004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        String result = checkGameState(board, n);
        System.out.println(result);
        
        scanner.close();
    }
    
    public static String checkGameState(char[][] board, int n) {
        boolean xWon = false;
        boolean oWon = false;
        
        // Check rows and columns
        for (int i = 0; i < n; i++) {
            // Check row i
            if (checkLine(board[i][0], board[i], n)) {
                if (board[i][0] == 'X') xWon = true;
                else if (board[i][0] == 'O') oWon = true;
            }
            
            // Check column i
            char first = board[0][i];
            if (first != '.' && checkColumn(board, i, n, first)) {
                if (first == 'X') xWon = true;
                else if (first == 'O') oWon = true;
            }
        }
        
        // Check main diagonal
        char mainDiagFirst = board[0][0];
        if (mainDiagFirst != '.' && checkMainDiagonal(board, n, mainDiagFirst)) {
            if (mainDiagFirst == 'X') xWon = true;
            else if (mainDiagFirst == 'O') oWon = true;
        }
        
        // Check anti-diagonal
        char antiDiagFirst = board[0][n-1];
        if (antiDiagFirst != '.' && checkAntiDiagonal(board, n, antiDiagFirst)) {
            if (antiDiagFirst == 'X') xWon = true;
            else if (antiDiagFirst == 'O') oWon = true;
        }
        
        // Determine result
        if (xWon) {
            return "Ganhou o X";
        } else if (oWon) {
            return "Ganhou o O";
        } else {
            // Check if game is incomplete or tie
            if (hasEmptyCells(board, n)) {
                return "Jogo incompleto";
            } else {
                return "Empate";
            }
        }
    }
    
    private static boolean checkLine(char first, char[] line, int n) {
        if (first == '.') return false;
        for (int i = 1; i < n; i++) {
            if (line[i] != first) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean checkColumn(char[][] board, int col, int n, char player) {
        for (int i = 1; i < n; i++) {
            if (board[i][col] != player) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean checkMainDiagonal(char[][] board, int n, char player) {
        for (int i = 1; i < n; i++) {
            if (board[i][i] != player) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean checkAntiDiagonal(char[][] board, int n, char player) {
        for (int i = 1; i < n; i++) {
            if (board[i][n-1-i] != player) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean hasEmptyCells(char[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    return true;
                }
            }
        }
        return false;
    }
}
