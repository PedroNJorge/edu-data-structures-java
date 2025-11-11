import java.util.*;

public class ED231 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); scanner.nextLine();
        int[] c = new int[n];
        int[] heights = new int[n];

        c[0] = scanner.nextInt();
        heights[0] = c[0] / 100;

        int max = 0, min = 100000000;
        int maxHeight = heights[0];
        int numLow = 0;
        int maxLowPeriod = 0, tempPeriod = 0;
        for (int i = 1; i < n; i++) {
            c[i] = scanner.nextInt();
            heights[i] = c[i] / 100;
            if (heights[i] > maxHeight) maxHeight = heights[i];
            int diff = c[i] - c[i-1];
            if (diff > max) max = diff;
            if (diff < min) min = diff;
            if (1.0*diff / c[i-1] <= 0.05) {
                tempPeriod++;
            } else if (tempPeriod > 0) {
                numLow++;
                if (tempPeriod > maxLowPeriod) maxLowPeriod = tempPeriod;
                tempPeriod = 0;
            }
        }
        if (tempPeriod > 0) numLow++;
        if (tempPeriod > maxLowPeriod) maxLowPeriod = tempPeriod;

        int flag = scanner.nextInt();
        scanner.close();

        switch (flag) {
            case 1:
                System.out.printf("%d %d\n", min, max);
                break;

            case 2:
                System.out.printf("%d %d\n", numLow, maxLowPeriod);
                break;

            case 3:
                for (int j = maxHeight; j > 0; j--) {
                    for (int i = 0; i < n; i++) {
                        if (heights[i] >= j) System.out.print('#');
                        else System.out.print('.');
                    }
                    System.out.println();
                }
                break;
        }
    }
}
