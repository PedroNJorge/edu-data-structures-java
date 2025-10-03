import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ex244 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int a = reader.nextInt();
        int b = reader.nextInt();
        reader.close();

        // Sieve of Eratosthenes
        // Step 1
        boolean[] isComposite = new boolean[b + 1];
        Arrays.fill(isComposite, false);
        isComposite[0] = isComposite[1] = true;
        
        // Step 2
        int p = 2;

        while (p <= b) {
            if (isComposite[p]) {
                p++;
                continue;
            }

            // Step 3
            for (int i = 2*p; i <= b; i += p) {
                isComposite[i] = true;
            }
            
            // Step 4
            p++;
        }

        // Step 5
        int primeCount = 0;
        for (int i = a; i <= b; i++) {
            if (!isComposite[i]) primeCount++;
        }

        System.out.println(primeCount);
    }
}
