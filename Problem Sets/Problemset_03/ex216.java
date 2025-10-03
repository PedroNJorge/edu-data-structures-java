import java.util.Scanner;

public class ex216 {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();
        s.nextLine();

        String[] grid = new String[n];
        for (int i = 0; i < n; i++) {
            grid[i] = s.nextLine();
        }
        s.close();

        int max_seq = 0, num_max = 0;
        int temp_seq = 0;

        // Check horizontal sequences
        for (int i = 0; i < n; i++) {
            temp_seq = 0;
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == '.') {
                    if (temp_seq > max_seq) {
                        max_seq = temp_seq;
                        num_max = 1;
                    } else if (temp_seq == max_seq) {
                        num_max++;
                    }
                    temp_seq = 0;
                } else {
                    temp_seq++;
                }
            }
            // Check last row case
            if (temp_seq > max_seq) {
                max_seq = temp_seq;
                num_max = 1;
            } else if (temp_seq == max_seq) {
                num_max++;
            }
        }

        // Check vertical sequences
        for (int j = 0; j < m; j++) {
            temp_seq = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i].charAt(j) == '.') {
                    if (temp_seq > max_seq) {
                        max_seq = temp_seq;
                        num_max = 1;
                    } else if (temp_seq == max_seq) {
                        num_max++;
                    }
                    temp_seq = 0;
                } else {
                    temp_seq++;
                }
            }
            // Check last row case
            if (temp_seq > max_seq) {
                max_seq = temp_seq;
                num_max = 1;
            } else if (temp_seq == max_seq) {
                num_max++;
            }
        }

        System.out.printf("%d %d\n", max_seq, num_max);
    }
}
