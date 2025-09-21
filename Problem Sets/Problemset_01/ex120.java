import java.util.Scanner;

public class ex120 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        myScanner.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n-1)/2 - (-Math.abs(i - n/2) + n/2); j++) {
                System.out.print(".");
            }
            for (int j = 0; j < n - 2*Math.abs(i - n/2); j++) {
                System.out.print("#");
            }
            for (int j = 0; j < (n-1)/2 - (-Math.abs(i - n/2) + n/2); j++) {
                System.out.print(".");
            }
            System.out.print("\n");
        }
    }
}
