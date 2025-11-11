import java.util.*;

public class ED254 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int c = 0; c < n; c++) {
            int T = scanner.nextInt();
            for (int i = 0; i < T/2; i++) {
                for (int j = 0; j < T; j++) {
                    if (i == j || j == T - i - 1) System.out.print("#");
                    else System.out.print(".");
                }
                System.out.println();
            }
            for (int i = 0; i < T - T/2; i++) {
                for (int j = 0; j < T; j++) {
                    if (j == T/2) System.out.print("#");
                    else System.out.print(".");
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}
