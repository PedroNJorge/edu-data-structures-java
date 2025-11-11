import java.util.*;

public class ED235 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            for (int j = 0; j < t; j++) {
                for (int k = 0; k < t; k++) {
                    char c = (k < t - j) ? '#' : '.';
                    System.out.print(c);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}
