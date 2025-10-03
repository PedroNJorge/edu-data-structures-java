import java.util.Scanner;

public class ex183 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = reader.nextInt();
        reader.nextLine();

        int sum = 0, max = 0, min = 0;
        sum = max = min = reader.nextInt();
        int temp;

        for (int i = 0; i < n - 1; i++) {
            temp = reader.nextInt();
            sum += temp;
            if (temp > max) max = temp;
            if (temp < min) min = temp;
        }

        double mean = (double) sum / n;
        System.out.printf("%.2f%n", mean);
        System.out.println(max - min);
        reader.close();
    }
}
